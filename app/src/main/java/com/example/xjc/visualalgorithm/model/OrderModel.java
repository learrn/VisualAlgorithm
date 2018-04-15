package com.example.xjc.visualalgorithm.model;

public class OrderModel {
    public static final int TYPE_COLOR = 1;
    public static final int TYPE_EXCHANGE = 2;

    private int type;
    private int color;
    private int firstIndex;
    private int secondIndex;

    public OrderModel() { }

    public OrderModel(int type, int color, int firstIndex, int secondIndex) {
        this.type = type;
        this.color = color;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }
}
