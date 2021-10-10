package com.example.pro2.model;


import lombok.Data;

@Data
public class Memory {
    int size;

    public Memory(int size) {
        this.size = size;
    }
}
