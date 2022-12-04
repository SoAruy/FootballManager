package ua.solyha.footballmanager.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TeamDto {
    private int id;

    private String name;

    private double balance;

    private int commission;

    private List<PlayerListDto> players;

    public TeamDto(int id, String name, double balance, int commission, List<PlayerListDto> players) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.commission = commission;
        this.players = players;
    }

    public TeamDto() {
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

    public List<PlayerListDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerListDto> players) {
        this.players = players;
    }
}
