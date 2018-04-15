package com.example.xjc.visualalgorithm.presenter;

import android.graphics.Canvas;

import com.example.xjc.visualalgorithm.view.ui.SortView;

public interface ISortViewPresenter {
    void onDraw(Canvas canvas);
    void onSizeChanged(int mWidth, int mHeight);
    void setView(SortView sortView);
    void exchangeRect(int firstIndex,int secondIndex);
    void changeColor(int firstIndex, int secondIndex, int color);
    void addOrder(int type, int color, int firstIndex, int secondIndex);
}
