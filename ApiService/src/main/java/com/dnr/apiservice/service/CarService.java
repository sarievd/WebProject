package com.dnr.apiservice.service;

import com.dnr.apiservice.model.Car;
import com.dnr.apiservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Optional<Car> getCar(Long id){
        return carRepository.findById(id);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(Car car){
        carRepository.save(car);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}
