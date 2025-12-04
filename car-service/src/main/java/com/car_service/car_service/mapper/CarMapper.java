package com.car_service.car_service.mapper;

import com.car_service.car_service.dto.CarDto;
import com.car_service.car_service.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
    public Car toEntity(CarDto dto) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setOwner(dto.getOwner());
        return car;
    }

    public void updateEntity(Car car, CarDto dto) {
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setOwner(dto.getOwner());
    }
}
