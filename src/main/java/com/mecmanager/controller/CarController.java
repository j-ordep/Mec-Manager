package com.mecmanager.controller;

import com.mecmanager.domain.model.Car;
import com.mecmanager.dto.request.CarRequest;
import com.mecmanager.dto.response.CarResponse;
import com.mecmanager.mapper.CarMapper;
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

    // todo se a placa ja estiver cadastrada

    @PostMapping()
    public CarResponse save(@RequestBody CarRequest car) {
        return carService.save(car);
    }

    @GetMapping()
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Car> findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @GetMapping("/license")
    public Optional<Car> findByLicensePlate(@RequestParam String licensePlate) {
        return carService.findByLicensePlate(licensePlate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

}
