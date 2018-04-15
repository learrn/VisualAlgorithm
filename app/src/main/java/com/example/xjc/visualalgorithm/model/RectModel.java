package com.example.xjc.visualalgorithm.model;

import android.graphics.Color;

/**
 * Created by xjc on 2018/4/1.
 */

public class RectModel {
    public static final int COLOR_NORMAL = 1;
    public static final int COLOR_CHOSED = 2;
    public static final int COLOR_CURRENT = 3;
    public static final int COLOR_FINISH = 4;

    private float index;
    private int value;
    private int initIndex;
    private int targetIndex;
    private int color;

    public RectModel() {
    }

    public RectModel(int index, int value) {
        this.initIndex = index;
        this.value = value;
        this.index = index;
        this.targetIndex = index;
        this.setColor(COLOR_NORMAL);
    }

    public int getTargetIndex() {
        return targetIndex;
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }

    public void setIndex(float index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getInitIndex() {
        return initIndex;
    }

    public void setInitIndex(int initIndex) {
        this.initIndex = initIndex;
    }

    public float getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }


    public int getRealColor() {
        switch (this.color) {
            case COLOR_CHOSED:
                return Color.rgb(0, 128, 0);
            case COLOR_CURRENT:
                return Color.rgb(220, 60, 20);
            case COLOR_FINISH:
                return Color.rgb(255, 165, 0);
            default:
                return Color.rgb(173, 216, 230);
        }
    }
}
