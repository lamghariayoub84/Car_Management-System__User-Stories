package com.rental.rental_service.controller;

import com.rental.rental_service.dto.RentalDto;
import com.rental.rental_service.model.Rental;
import com.rental.rental_service.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService service;

    @PostMapping("/create")
    public Rental create(@RequestBody RentalDto dto) {
        return service.createRental(dto);
    }

    @GetMapping("/all")
    public List<Rental> getAll() {
        return service.getAllRentals();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRental(id);
    }
}
