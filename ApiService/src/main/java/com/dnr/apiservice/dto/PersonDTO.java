package com.dnr.apiservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

public class PersonDTO {
//    private String photoPath;
    private String name;
    private String surname;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;
    private String driverLicense;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate driverLicenseExpiringDate;

    public PersonDTO() {
    }

    public PersonDTO( String name, String surname, LocalDate birthDate, String driverLicense, LocalDate driverLicenseExpiringDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.driverLicense = driverLicense;
        this.driverLicenseExpiringDate = driverLicenseExpiringDate;
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

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", driverLicense='" + driverLicense + '\'' +
                ", driverLicenseExpiringDate=" + driverLicenseExpiringDate +
                '}';
    }
}
