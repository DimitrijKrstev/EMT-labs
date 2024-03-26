package com.example.emtlab1.model.dto;

import com.example.emtlab1.model.Host;
import com.example.emtlab1.model.enums.AccommodationCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccommodationDto {
    String name;
    AccommodationCategory category;
    Long hostId;
    Integer numRooms;
}
