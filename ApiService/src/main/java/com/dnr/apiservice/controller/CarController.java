package com.dnr.apiservice.controller;

import com.dnr.apiservice.model.Car;
import com.dnr.apiservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/{id}")
    public Optional<Car> getCar(@PathVariable("id") Long id){
        return carService.getCar(id);
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @PostMapping("/car")
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}
