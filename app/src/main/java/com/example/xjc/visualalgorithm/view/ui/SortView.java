package com.example.xjc.visualalgorithm.view.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.xjc.visualalgorithm.presenter.ISortViewPresenter;

public class SortView extends View {
    private ISortViewPresenter sortViewPresenter;
    public SortView(Context context) {
        super(context);
    }

    public SortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SortView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SortView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setSortViewPresenter(ISortViewPresenter sortViewPresenter){
        this.sortViewPresenter = sortViewPresenter;
        this.sortViewPresenter.setView(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (sortViewPresenter != null){
            sortViewPresenter.onDraw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (sortViewPresenter != null){
            sortViewPresenter.onSizeChanged(getWidth(),getHeight());
        }
    }
}
