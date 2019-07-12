package com.dnr.apiservice.model;

import com.dnr.apiservice.annotation.FutureLocalDateConstraint;
import com.dnr.apiservice.annotation.PastLocalDateConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Person {
    @Id
    @SequenceGenerator(name = "mySeqGenPerson", sequenceName = "mySeqPerson", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGenPerson")
    private Long person_id;
    @Column
    private String photoPath;
    @Column
    @Size(min=2,max=30)
    @Pattern(regexp = "[-_A-Za-zА-Яа-яёЁ]*")
    @NotEmpty(message = "Please, provide a name")
    @NotNull(message = "Please, fill the field!")
    private String name;
    @Column
    @Size(min=2,max=30)
    @Pattern(regexp = "[-_A-Za-zА-Яа-яёЁ]*")
    @NotEmpty(message = "Please, provide a surname")
    @NotNull(message = "Please, fill the field!")
    private String surname;
    @Column
    @PastLocalDateConstraint(message = "The date can not be in the future!")
    @NotNull(message = "Please, fill the field!")
    private LocalDate birthDate;
    @Column
    @Size(min=10,max=10)
    @Pattern(regexp = "[0-9A-Za-z]*")
    @NotEmpty(message = "Please, provide a driver license")
    @NotNull(message = "Please, fill the field!")
    private String driverLicense;
    @Column
    @FutureLocalDateConstraint(message = "The date can not be in the past!")
    @NotNull(message = "Please, fill the field!")
    private LocalDate driverLicenseExpiringDate;
    @ManyToMany
    @JoinTable(name = "persons_car",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    Set<Car> cars;
    @OneToOne(optional = false, mappedBy = "person")
    public PersonBlackList personBlackList;


    public Person() {
    }


    public Person(String photoPath, @Size(min = 2, max = 30) @Pattern(regexp = "[-_A-Za-zА-Яа-яёЁ]*") @NotEmpty(message = "Please, provide a name") @NotNull(message = "Please, fill the field!") String name, @Size(min = 2, max = 30) @Pattern(regexp = "[-_A-Za-zА-Яа-яёЁ]*") @NotEmpty(message = "Please, provide a surname") @NotNull(message = "Please, fill the field!") String surname, @PastLocalDateConstraint(message = "The date can not be in the future!") @NotNull(message = "Please, fill the field!") LocalDate birthDate, @Size(min = 10, max = 10) @Pattern(regexp = "[0-9A-Za-z]*") @NotEmpty(message = "Please, provide a driver license") @NotNull(message = "Please, fill the field!") String driverLicense, @FutureLocalDateConstraint(message = "The date can not be in the past!") @NotNull(message = "Please, fill the field!") LocalDate driverLicenseExpiringDate, Set<Car> cars, PersonBlackList personBlackList) {
        this.photoPath = photoPath;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.driverLicense = driverLicense;
        this.driverLicenseExpiringDate = driverLicenseExpiringDate;
        this.cars = cars;
        this.personBlackList = personBlackList;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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

    public PersonBlackList getPersonBlackList() {
        return personBlackList;
    }

    public void setPersonBlackList(PersonBlackList personBlackList) {
        this.personBlackList = personBlackList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", photoPath='" + photoPath + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", driverLicense='" + driverLicense + '\'' +
                ", driverLicenseExpiringDate=" + driverLicenseExpiringDate +
                ", cars=" + cars +
                ", personBlackList=" + personBlackList +
                '}';
    }
}
