package com.example.pro2.model;

import lombok.Data;

@Data
public class Servers {
    int id;
    int amount;

    public Servers(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
