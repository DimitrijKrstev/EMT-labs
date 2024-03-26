package com.example.emtlab1.repository.views;

import com.example.emtlab1.model.views.UserAndAccommodationView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserAndAccommodationViewRepository extends JpaRepository<UserAndAccommodationView, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.USER_PER_ACCOMMODATION", nativeQuery = true)
    void refreshMaterializedView();
}
