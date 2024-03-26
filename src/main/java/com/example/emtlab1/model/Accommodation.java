package com.example.emtlab1.model;

import com.example.emtlab1.model.enums.AccommodationCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    Host host;

    @Enumerated
    AccommodationCategory category;

    String name;
    Integer numRooms;
}
