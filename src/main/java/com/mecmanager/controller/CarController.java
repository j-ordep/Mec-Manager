package com.mecmanager.controller;

import com.mecmanager.entity.Car;
import com.mecmanager.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mecmanager/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    public Car save(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping()
    public List<Car> getAll() {
        return carService.findAllCars();
    }

    @GetMapping("{id}")
    public Optional<Car> getById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @GetMapping("{licensePlate}")
    public Optional<Car> findCarByLicensePlate(@PathVariable String licensePlate) {
        return carService.findCarByLicensePlate(licensePlate);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

}
