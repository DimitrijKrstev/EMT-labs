package com.example.emtlab1.web.rest;

import com.example.emtlab1.model.Accommodation;
import com.example.emtlab1.model.dto.AccommodationDto;
import com.example.emtlab1.service.AccommodationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
@AllArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;

    @GetMapping("/list-all")
    public List<Accommodation> getAllAccommodations(){
        return accommodationService.listAll();
    }

    @PutMapping("/add")
    public Accommodation addAccommodation(AccommodationDto accommodationDto){
        return accommodationService.addAccommodation(
                accommodationDto.getName(),
                accommodationDto.getCategory(),
                accommodationDto.getHostId(),
                accommodationDto.getNumRooms()
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccommodation(@PathVariable Long id){
        accommodationService.deleteAccommodationById(id);
    }

    @PutMapping("/edit/{id}")
    public Accommodation editAccommodation(@PathVariable Long id, AccommodationDto accommodationDto){
        return accommodationService.editAccommodationById(
                id,
                accommodationDto.getName(),
                accommodationDto.getCategory(),
                accommodationDto.getHostId(),
                accommodationDto.getNumRooms()
        );
    }

    @PostMapping("/occupy/{id}")
    public Accommodation editAccommodation(@PathVariable Long id) {
        return accommodationService.occupyRoomById(id);
    }
}
