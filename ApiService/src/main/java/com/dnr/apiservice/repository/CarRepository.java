package com.dnr.apiservice.repository;

import com.dnr.apiservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,  Long> {
}
