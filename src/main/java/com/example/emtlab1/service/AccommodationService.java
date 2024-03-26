package com.example.emtlab1.service;

import com.example.emtlab1.model.Accommodation;
import com.example.emtlab1.model.Host;
import com.example.emtlab1.model.enums.AccommodationCategory;

import java.util.List;

public interface AccommodationService {
    public List<Accommodation> listAll();
    public Accommodation addAccommodation(String name, AccommodationCategory category, Long hostId, int numRooms);
    public void deleteAccommodationById(Long id);
    public Accommodation editAccommodationById(Long id, String name, AccommodationCategory category, Long hostId, int numRooms);
    public Accommodation occupyRoomById(Long id);
}
