package com.dnr.apiservice.controller;

import com.dnr.apiservice.model.Car;
import com.dnr.apiservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") Long id){
        return carService.getCar(id);
    }

    @GetMapping("/all")
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @PostMapping("/")
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}
