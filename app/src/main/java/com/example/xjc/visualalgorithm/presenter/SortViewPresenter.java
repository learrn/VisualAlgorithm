package com.example.xjc.visualalgorithm.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.xjc.visualalgorithm.model.OrderModel;
import com.example.xjc.visualalgorithm.model.RectModel;
import com.example.xjc.visualalgorithm.view.ui.SortView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SortViewPresenter implements ISortViewPresenter {
    public int mOffset = 10;
    private Context mContext;
    private ArrayList<RectModel> rectModels;
    private Paint mTextPaint, mRectPaint;
    private SortView sortView;
    private float rectIndex;
    private int rectValue, rectRealColor;
    private int mWidth, mHeight, mRectWidth;
    private int oldFirstIndex, oldSecondIndex, oldColor;
    private Queue<OrderModel> queue;
    private OrderModel tempOrder, curOrder;
    private Boolean isChanging = false;

    public SortViewPresenter(Context context, ArrayList<RectModel> rectModels) {
        this.mContext = context;
        this.rectModels = rectModels;
        init();
    }

    private void init() {
        oldFirstIndex = 0;
        oldSecondIndex = 0;
        queue = new LinkedList<>();
        mTextPaint = new Paint();
        mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStrokeWidth(3);
        mTextPaint.setTextSize(25);
        mTextPaint.setColor(Color.BLACK);
        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.rgb(173, 216, 230));
    }


    @Override
    public void onDraw(Canvas canvas) {
        isChanging = false;
        for (RectModel rectModel : rectModels) {
            rectIndex = rectModel.getIndex();
            rectValue = rectModel.getValue();
            rectRealColor = rectModel.getRealColor();
            mRectPaint.setColor(rectRealColor);
            @SuppressLint("DrawAllocation") Rect targetRect = new Rect((int) (mWidth * 0.2 / 2 + mRectWidth * rectIndex + mOffset), mHeight - mHeight * rectValue / 50, (int) (mWidth * 0.2 / 2 + mRectWidth * (rectIndex + 1)), mHeight);
            canvas.drawRect(targetRect, mRectPaint);
            mTextPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(Integer.toString(rectValue), targetRect.centerX(), targetRect.bottom - mOffset, mTextPaint);
            if (Math.abs(rectModel.getTargetIndex() - rectIndex) > 0.01) {
                isChanging = true;
                float tempIndex = (rectModel.getTargetIndex() - rectIndex) / 5;
                rectModel.setIndex(rectIndex + tempIndex);
                sortView.postInvalidate();
            }
        }
        if (!isChanging) {
            curOrder = queue.poll();
            if (curOrder != null) {
                switch (curOrder.getType()) {
                    case OrderModel.TYPE_COLOR:
                        changeColor(curOrder.getFirstIndex(), curOrder.getSecondIndex(), curOrder.getColor());
                        break;
                    case OrderModel.TYPE_EXCHANGE:
                        exchangeRect(curOrder.getFirstIndex(), curOrder.getSecondIndex());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void onSizeChanged(int mWidth, int mHeight) {
        this.mWidth = mWidth;
        this.mHeight = mHeight;
        mRectWidth = (int) (mWidth * 0.8 / rectModels.size());
    }

    @Override
    public void setView(SortView sortView) {
        this.sortView = sortView;
    }

    @Override
    public void exchangeRect(int firstIndex, int secondIndex) {
        rectModels.get(firstIndex).setTargetIndex(secondIndex);
        rectModels.get(secondIndex).setTargetIndex(firstIndex);
        Collections.swap(rectModels, firstIndex, secondIndex);
        sortView.postInvalidateDelayed(500);
    }

    @Override
    public void changeColor(int firstIndex, int secondIndex, int color) {
        switch (color) {
            case RectModel.COLOR_CHOSED:
            case RectModel.COLOR_CURRENT:
                clearColor(color);
                break;
            default:
                break;
        }
        rectModels.get(firstIndex).setColor(color);
        if (firstIndex != secondIndex) {
            rectModels.get(secondIndex).setColor(color);
        }
        sortView.postInvalidateDelayed(500);
    }

    private void clearColor(int color) {
        for (RectModel rectModel : rectModels) {
            if (color == rectModel.getColor()) {
                rectModel.setColor(RectModel.COLOR_NORMAL);
            }
        }
    }

    @Override
    public void addOrder(int type, int color, int firstIndex, int secondIndex) {
        tempOrder = new OrderModel(type, color, firstIndex, secondIndex);
        queue.offer(tempOrder);
        sortView.postInvalidate();
    }
}
