package com.car_service.car_service.service;

import com.car_service.car_service.dto.CarDto;
import com.car_service.car_service.mapper.CarMapper;
import com.car_service.car_service.model.Car;
import com.car_service.car_service.model.CarStatus;
import com.car_service.car_service.repository.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;

    public CarService(CarRepository repository, CarMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Car addCar(CarDto dto) {
        Car car = mapper.toEntity(dto);
        return repository.save(car);
    }

    public Car updateCar(Long id, CarDto dto) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        mapper.updateEntity(car, dto);
        return repository.save(car);
    }

    public List<Car> getAllCars() {
     return (List<Car>) repository.findAll();
    }

    public void deleteCar(Long id) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (car.getStatus().equals(CarStatus.RENTED)) {
            throw new RuntimeException("Cannot delete car because it is currently rented");
        }

        repository.delete(car);
    }

}
