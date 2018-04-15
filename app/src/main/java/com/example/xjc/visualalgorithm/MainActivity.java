package com.example.xjc.visualalgorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xjc.visualalgorithm.model.OrderModel;
import com.example.xjc.visualalgorithm.model.RectModel;
import com.example.xjc.visualalgorithm.presenter.SortViewPresenter;
import com.example.xjc.visualalgorithm.view.ui.SortView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private SortViewPresenter sortViewPresenter;
    private int[] values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<RectModel> rectModels = new ArrayList<>();
        test(rectModels);
        sortViewPresenter = new SortViewPresenter(this, rectModels);
        SortView sortView = findViewById(R.id.sort_view);
        sortView.setSortViewPresenter(sortViewPresenter);
        bubbySort(values);
    }

    private void test(ArrayList<RectModel> rectModels) {
        values = new int[]{9, 43, 17, 27, 6};
        for (int i = 0; i < 5; i++) {
            RectModel rectModel = new RectModel(i, values[i]);
            rectModels.add(rectModel);
        }
    }

    private void bubbySort(int[] array){
        int size = array.length;
        int temp = 0;
        boolean flag = true;
        for (int i=0;i<size-1&flag;i++){
            flag = false;
            for (int j = 0; j<size-1-i; j++){
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_CHOSED,j,j+1);
                if (array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE,RectModel.COLOR_CHOSED,j,j+1);
                    flag = true;
                }
//                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_NORMAL,j,j+1);
            }
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,size-1-i,size-1-i);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,0,0);
    }

    private void selectSort(int[] numbers) {
        int size = numbers.length; // 数组长度
        int temp = 0; // 中间变量
        for (int i = 0; i < size-1; i++) {
            int k = i; // 待确定的位置
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_CURRENT,k,k);
            // 选择出应该在第i个位置的数
            for (int j = i+1; j < size; j++) {
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_CHOSED,j,j);
                if (numbers[j] < numbers[k]) {
                    k = j;
                    sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_CURRENT,k,k);
                }
            }
            // 交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
            sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE,RectModel.COLOR_CHOSED,k,i);
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,i,i);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,size-1,size-1);
    }

    private void insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,0,0);
        for (int i = 1; i < size; i++) {
            temp = numbers[i];
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_CURRENT,i,i);
            // 假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_CHOSED,j-1,j-1);
                sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE,RectModel.COLOR_CHOSED,j,j-1);
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,j,j);
            }
            numbers[j] = temp;
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,i,i);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR,RectModel.COLOR_FINISH,0,0);
    }
}

