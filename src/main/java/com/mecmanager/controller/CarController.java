package com.mecmanager.controller;

import com.mecmanager.domain.model.Car;
import com.mecmanager.dto.request.CarRequest;
import com.mecmanager.dto.response.CarResponse;
import com.mecmanager.exception.DuplicatedLicensePlateException;
import com.mecmanager.mapper.CarMapper;
import com.mecmanager.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> save(@RequestBody CarRequest car) {
        try {
            CarResponse response = carService.save(car);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (DuplicatedLicensePlateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error");
        }

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
