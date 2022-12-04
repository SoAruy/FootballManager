package ua.solyha.footballmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @Min(value = 0, message = "Team balance should be greater than 0")
    @Column(name = "balance")
    private double balance;

    @Min(value = 0, message = "Team commission should be greater than 0")
    @Max(value = 10, message = "Team commission should be less than 10")
    @Column(name = "commission")
    private int commission;

    public Team(String name, double balance, int commission) {
        this.name = name;
        this.balance = balance;
        this.commission = commission;
    }

    public Team() {
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
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
