package com.company;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String description;
    private double cost;

    public Item(int Id, String descrip, double val) {
        id = Id;
        description = descrip;
        cost = val;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
