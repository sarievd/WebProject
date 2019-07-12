package com.dnr.apiservice.model;

import com.dnr.apiservice.annotation.PastLocalDateConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Car {
    @Id
    @SequenceGenerator(name = "mySeqGenCar", sequenceName = "mySeqCar", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGenCar")
    private Long car_id;
    @Column
    @Size(min=2,max=30)
    @Pattern(regexp = "[-_0-9A-Za-zА-Яа-яёЁ]*")
    @NotEmpty(message = "Please, provide the mark of auto!")
    @NotNull(message = "Please, fill the field!")
    private String carMark;
    @Column
    @Size(min=2,max=30)
    @Pattern(regexp = "[-_0-9A-Za-zА-Яа-яёЁ]*")
    @NotEmpty(message = "Please, provide the model of auto!")
    @NotNull(message = "Please, fill the field!")
    private String carModel;
    @Column
    @PastLocalDateConstraint(message = "You can not add th date in the future!")
    @NotNull(message = "Please, fill the field!")
    private LocalDate carYear;
    @ManyToMany(mappedBy = "cars")
    Set<Person> personSet;

    public Car() {
    }

    public Car(@Size(min = 2, max = 30) @Pattern(regexp = "[0-9A-Za-zА-Яа-яёЁ]*") @NotEmpty(message = "Please, provide the mark of auto!") @NotNull(message = "Please, fill the field!") String carMark, @Size(min = 2, max = 30) @Pattern(regexp = "[0-9A-Za-zА-Яа-яёЁ]*") @NotEmpty(message = "Please, provide the model of auto!") @NotNull(message = "Please, fill the field!") String carModel, LocalDate carYear, Set<Person> personSet) {
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
