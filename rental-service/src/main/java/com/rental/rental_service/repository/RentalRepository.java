package com.rental.rental_service.repository;

import com.rental.rental_service.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
