package com.car_service.car_service.controller;

import com.car_service.car_service.dto.CarDto;
import com.car_service.car_service.model.Car;
import com.car_service.car_service.repository.CarRepository;
import com.car_service.car_service.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }
    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody CarDto dto) {
        return service.addCar(dto);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody CarDto dto) {
        return service.updateCar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        service.deleteCar(id);
        return "Car deleted successfully";
    }

}
