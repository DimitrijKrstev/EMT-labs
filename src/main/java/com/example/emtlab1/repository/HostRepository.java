package com.example.emtlab1.repository;

import com.example.emtlab1.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
