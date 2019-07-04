package com.dnr.apiservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long person_id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private LocalDate birthDate;
    @Column
    private String driverLicense;
    @Column
    private LocalDate driverLicenseExpiringDate;
    @ManyToMany
    @JoinTable(name = "persons_car",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    Set<Car> cars;

    public Person() {
    }

    public Person(String name, String surname, LocalDate birthDate, String driverLicense, LocalDate driverLicenseExpiringDate, Set<Car> cars) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.driverLicense = driverLicense;
        this.driverLicenseExpiringDate = driverLicenseExpiringDate;
        this.cars = cars;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public LocalDate getDriverLicenseExpiringDate() {
        return driverLicenseExpiringDate;
    }

    public void setDriverLicenseExpiringDate(LocalDate driverLicenseExpiringDate) {
        this.driverLicenseExpiringDate = driverLicenseExpiringDate;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
