package ua.solyha.footballmanager.dto;

import jakarta.validation.constraints.*;

public class PlayerUpdateDto{
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @NotEmpty
    private String name;

    @Min(value = 18, message = "Age should be greater than 18")
    @Max(value = 60, message = "Age should be less than 60")
    private int age;

    @Min(value = 0, message = "Experience should be greater than 0")
    private int experience;

    @Min(value = 0, message = "Salary should be greater than 0")
    private double salary;

    private int teamId;

    public PlayerUpdateDto(String name, int age, int experience, double salary, int teamId) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.teamId = teamId;
    }

    public PlayerUpdateDto() {
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
