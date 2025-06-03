package com.mecmanager.service;

import com.mecmanager.domain.model.Car;
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

    public Car saveCar(Car Car) {
        return carRepository.save(Car);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> findCarByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
