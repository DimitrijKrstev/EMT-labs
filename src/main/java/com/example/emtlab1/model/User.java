package com.example.emtlab1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="airbnb_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    Accommodation accommodation;

    String name;
}
