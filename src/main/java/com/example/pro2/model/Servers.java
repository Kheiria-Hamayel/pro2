package com.example.pro2.model;

import lombok.Data;

@Data
public class Servers {
    int id;
    int allocationSize;

    public Servers(int id, int allocationSize) {
        this.id = id;
        this.allocationSize = allocationSize;
    }
}
