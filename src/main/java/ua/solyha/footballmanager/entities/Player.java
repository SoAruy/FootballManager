package ua.solyha.footballmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Player")
public class Player{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    @NotNull
    private String name;

    @Min(value = 18, message = "Age should be greater than 18")
    @Max(value = 60, message = "Age should be less than 60")
    @Column(name = "age")
    private int age;

    @Min(value = 0, message = "Experience should be greater than 0")
    @Column(name = "experience")
    private int experience;

    @Min(value = 0, message = "Salary should be greater than 0")
    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    public Player(String name, int age, int experience, double salary, Team team) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.team = team;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
