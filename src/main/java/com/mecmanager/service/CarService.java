package com.mecmanager.service;

import com.mecmanager.domain.model.Car;
import com.mecmanager.dto.request.CarRequest;
import com.mecmanager.dto.response.CarResponse;
import com.mecmanager.mapper.CarMapper;
import com.mecmanager.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarResponse save(CarRequest carRequest) {
        if (carRepository.findByLicensePlate(carRequest.licensePlate()).isPresent()) {
            return null;
        }
        Car savedCar = CarMapper.toDomain(carRequest);
        carRepository.save(savedCar);
        return CarMapper.toResponse(savedCar);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

}
