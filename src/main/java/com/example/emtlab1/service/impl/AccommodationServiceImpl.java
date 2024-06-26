package com.example.emtlab1.service.impl;

import com.example.emtlab1.model.Accommodation;
import com.example.emtlab1.model.dto.AccommodationDto;
import com.example.emtlab1.model.enums.AccommodationCategory;
import com.example.emtlab1.model.events.AccommodationNoRoomsEvent;
import com.example.emtlab1.repository.AccommodationRepository;
import com.example.emtlab1.repository.HostRepository;
import com.example.emtlab1.repository.views.UserAndAccommodationViewRepository;
import com.example.emtlab1.service.AccommodationService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{
    AccommodationRepository accommodationRepository;
    HostRepository hostRepository;
    UserAndAccommodationViewRepository userAndAccommodationViewRepository;
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<Accommodation> listAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation addAccommodation(String name, AccommodationCategory category, Long hostId, int numRooms) {
        Accommodation newAccommodation = accommodationRepository.save(Accommodation.builder()
                .name(name)
                .category(category)
                .host(hostRepository.findById(hostId).orElse(null))
                .numRooms(numRooms)
                .build());
        //userAndAccommodationViewRepository.refreshMaterializedView();
        return newAccommodation;
    }

    @Override
    public Accommodation addAccommodation(AccommodationDto accommodationDto) {
        return addAccommodation(accommodationDto.getName(), accommodationDto.getCategory(), accommodationDto.getHostId(),
                accommodationDto.getNumRooms());
    }

    @Override
    public void deleteAccommodationById(Long id) {
        //userAndAccommodationViewRepository.refreshMaterializedView();
        accommodationRepository.deleteById(id);
        //userAndAccommodationViewRepository.refreshMaterializedView();
    }

    @Override
    public Accommodation editAccommodationById(Long id, String name, AccommodationCategory category, Long hostId, int numRooms) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        accommodation.setName(name);
        accommodation.setCategory(category);
        accommodation.setHost(hostRepository.findById(hostId).orElse(null));
        accommodation.setNumRooms(numRooms);
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation editAccommodationById(Long id, AccommodationDto accommodationDto) {
        return editAccommodationById(id, accommodationDto.getName(), accommodationDto.getCategory(),
                accommodationDto.getHostId(), accommodationDto.getNumRooms());
    }

    @Override
    public Accommodation occupyRoomById(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        accommodation.setNumRooms(accommodation.getNumRooms() - 1);
        if(accommodation.getNumRooms() == 0) applicationEventPublisher.publishEvent(new AccommodationNoRoomsEvent(accommodation));
        return accommodationRepository.save(accommodation);
    }
}
