package com.example.emtlab1.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Getter
@Setter
@Subselect("SELECT * FROM public.USER_PER_ACCOMMODATION")
@Immutable
public class UserAndAccommodationView {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "accommodationId")
    private Integer accommodationId;
}
