package com.rental.rental_service.service;

import com.rental.rental_service.dto.RentalDto;
import com.rental.rental_service.model.Rental;
import com.rental.rental_service.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalService {

    private final RentalRepository repository;

    public RentalService(RentalRepository repository) {
        this.repository = repository;
    }

    public Rental createRental(RentalDto dto) {
        Rental rental = new Rental();
        rental.setCarId(dto.getCarId());
        rental.setUserId(dto.getUserId());
        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        rental.setPrice(dto.getPrice());

        return repository.save(rental);
    }

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    public void deleteRental(Long id) {
        repository.deleteById(id);
    }
}
