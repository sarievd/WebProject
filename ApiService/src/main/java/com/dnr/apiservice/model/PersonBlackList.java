package com.dnr.apiservice.model;

import com.dnr.apiservice.annotation.FutureLocalDateConstraint;
import com.dnr.apiservice.annotation.PastLocalDateConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class PersonBlackList {
    @Id
    @SequenceGenerator(name = "mySeqGenPersonBlackList", sequenceName = "mySeqPersonBlackList", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGenPersonBlackList")
     private Long bl_id;
    @OneToOne(optional = false)
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
    @Column

    @Size(min=1,max=256)
    @NotEmpty(message = "Please, write the reason!")
    @NotNull(message = "Please, fill the field!")
    private String definition; //The reason why person was added to black list!;
    @Column
    @PastLocalDateConstraint(message = "You can not add the person to black list by the future!")
    @NotNull(message = "Please, fill the field!")
    private LocalDate addingDate;  //Date, when the person was added to black list;
    @Column
    @FutureLocalDateConstraint(message = "You can not add the person to black list by the past!")
    @NotNull(message = "Please, fill the field!")
    private LocalDate expirngDate; //Date, when the person is going to be removed from black list;

    public PersonBlackList() {
    }

    public PersonBlackList(Person person, @Size(min = 1, max = 256) @NotEmpty(message = "Please, write the reason!") @NotNull(message = "Please, fill the field!") String definition, @PastLocalDateConstraint(message = "You can not add the person to black list by the future!") @NotNull(message = "Please, fill the field!") LocalDate addingDate, @FutureLocalDateConstraint(message = "You can not add the person to black list by the past!") @NotNull(message = "Please, fill the field!") LocalDate expirngDate) {
        this.person = person;
        this.definition = definition;
        this.addingDate = addingDate;
        this.expirngDate = expirngDate;
    }

    public Long getBl_id() {
        return bl_id;
    }

    public void setBl_id(Long bl_id) {
        this.bl_id = bl_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public LocalDate getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(LocalDate addingDate) {
        this.addingDate = addingDate;
    }

    public LocalDate getExpirngDate() {
        return expirngDate;
    }

    public void setExpirngDate(LocalDate expirngDate) {
        this.expirngDate = expirngDate;
    }

    @Override
    public String toString() {
        return "PersonBlackList{" +
                "bl_id=" + bl_id +
                ", person=" + person +
                ", definition='" + definition + '\'' +
                ", addingDate=" + addingDate +
                ", expirngDate=" + expirngDate +
                '}';
    }
}
