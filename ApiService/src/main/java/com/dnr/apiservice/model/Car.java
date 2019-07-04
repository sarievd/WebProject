package com.dnr.apiservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long car_id;
    @Column
    private String carMark;
    @Column
    private String carModel;
    @Column
    private LocalDate carYear;
    @ManyToMany(mappedBy = "cars")
    Set<Person> personSet;

    public Car() {
    }

    public Car(String carMark, String carModel, LocalDate carYear, Set<Person> personSet) {
        this.carMark = carMark;
        this.carModel = carModel;
        this.carYear = carYear;
        this.personSet = personSet;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public LocalDate getCarYear() {
        return carYear;
    }

    public void setCarYear(LocalDate carYear) {
        this.carYear = carYear;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }
}
