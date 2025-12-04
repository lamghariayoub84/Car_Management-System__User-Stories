package com.car_service.car_service.repository;

import com.car_service.car_service.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
