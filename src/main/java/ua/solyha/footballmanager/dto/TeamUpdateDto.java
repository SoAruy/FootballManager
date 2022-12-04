package ua.solyha.footballmanager.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class TeamUpdateDto {
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @NotNull
    private String name;

    @Min(value = 0, message = "Team balance should be greater than 0")
    private double balance;

    @Min(value = 0, message = "Team commission should be greater than 0")
    @Max(value = 10, message = "Team commission should be less than 10")
    private int commission;

    public TeamUpdateDto(String name, double balance, int commission) {
        this.name = name;
        this.balance = balance;
        this.commission = commission;
    }

    public TeamUpdateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
