package ru.malyushin.practika3Motozov.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("sex")
    private Boolean sex;
    @Column(name = "birth_date")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    @Column(name = "salary_multiplier")
    @JsonProperty("salary_multiplier")
    private Double salaryMultiplier;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    @JsonProperty("position")
    private Position position;

    public Stuff() {}

    public Stuff(String surname, String name, String patronymic, Boolean sex, LocalDate birthDate, Double salaryMultiplier, Position position) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.birthDate = birthDate;
        this.salaryMultiplier = salaryMultiplier;
        this.position = position;
    }

    public UUID getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalaryMultiplier() {
        return salaryMultiplier;
    }

    public void setSalaryMultiplier(Double salaryMultiplier) {
        this.salaryMultiplier = salaryMultiplier;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
