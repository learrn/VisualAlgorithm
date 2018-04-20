package com.example.xjc.visualalgorithm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.model.OrderModel;
import com.example.xjc.visualalgorithm.model.RectModel;
import com.example.xjc.visualalgorithm.model.SortCode;
import com.example.xjc.visualalgorithm.presenter.SortViewPresenter;
import com.example.xjc.visualalgorithm.view.ui.SortView;

import java.util.ArrayList;

public class AnimationFragment extends Fragment {
    private static final String EXTRA_CONTENT = "content";
    private int sortId;
    private SortViewPresenter sortViewPresenter;
    private int[] values;
    private int[] initValues;

    public static AnimationFragment newInstance(int sortId) {
        Bundle arguments = new Bundle();
        arguments.putInt(EXTRA_CONTENT, sortId);
        AnimationFragment animationfragment = new AnimationFragment();
        animationfragment.setArguments(arguments);
        return animationfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_tab_animation, null);
        ArrayList<RectModel> rectModels = new ArrayList<>();
        test(rectModels);
        sortViewPresenter = new SortViewPresenter(getContext(), rectModels);
        SortView sortView = contentView.findViewById(R.id.sort_view);
        sortView.setSortViewPresenter(sortViewPresenter);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sortId = getArguments().getInt(EXTRA_CONTENT, 0);
    }

    private void startAnimation(int sortId) {
        switch (sortId) {
            case SortCode.BUBBLE_SORT:
                bubbleSort(values);
                break;
            case SortCode.SELECT_SORT:
                selectSort(values);
                break;
            case SortCode.INSERT_SORT:
                insertSort(values);
                break;
            case SortCode.SHELL_SORT:
                shellSort(values);
                break;
            case SortCode.HEAP_SORT:
                heapSort(values);
                break;
            case SortCode.QUICK_SORT:
                quickSort(values);
                break;
            case SortCode.MERGE_SORT:
                merageSort(values, 0, values.length);
                break;
            default:
                break;
        }
    }

    private void test(ArrayList<RectModel> rectModels) {
        values = new int[]{9, 43, 17, 27, 6};
        for (int i = 0; i < 5; i++) {
            RectModel rectModel = new RectModel(i, values[i]);
            rectModels.add(rectModel);
        }
        initValues = values.clone();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            startAnimation(sortId);
        } else if (sortViewPresenter != null) {
            sortViewPresenter.resetView();
            values = initValues.clone();
        }
    }

    private void bubbleSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < size - 1 & flag; i++) {
            flag = false;
            for (int j = 0; j < size - 1 - i; j++) {
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CHOSED, j, j + 1);
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CHOSED, j, j + 1);
                    flag = true;
                }
            }
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, size - 1 - i, size - 1 - i);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, 0, 0);
    }

    private void selectSort(int[] numbers) {
        int size = numbers.length; // 数组长度
        int temp = 0; // 中间变量
        for (int i = 0; i < size - 1; i++) {
            int k = i; // 待确定的位置
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CURRENT, k, k);
            // 选择出应该在第i个位置的数
            for (int j = i + 1; j < size; j++) {
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CHOSED, j, j);
                if (numbers[j] < numbers[k]) {
                    k = j;
                    sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CURRENT, k, k);
                }
            }
            // 交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
            sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CHOSED, k, i);
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, i, i);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, size - 1, size - 1);
    }

    private void insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, 0, 0);
        for (int i = 1; i < size; i++) {
            temp = numbers[i];
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CURRENT, i, i);
            // 假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CHOSED, j - 1, j - 1);
                sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CHOSED, j, j - 1);
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, j, j);
            }
            numbers[j] = temp;
            sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, i, j);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, 0, 0);
    }

    // 希尔排序
    private void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        // 每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CHOSED, j, j - increment);
                    if (temp < data[j - increment])// 从小到大排
                    {
                        data[j] = data[j - increment];
                        sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CHOSED, j, j - increment);
                    } else {
                        break;
                    }
                }
                data[j] = temp;
            }
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, -1, -1);
    }

    // 堆排序
    public void heapSort(int[] a) {
        int arrayLength = a.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
        }
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_FINISH, -1, -1);
    }

    // 对data数组从0到lastIndex建大顶堆
    private void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    // 交换
    private void swap(int[] data, int i, int j) {
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CHOSED, i, j);
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CHOSED, i, j);
    }

    // 快速排序
    private void quickSort(int[] numbers) {
        if (numbers.length > 0) // 查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }

    private void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
        quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序
        quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
    }

    private int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; // 数组的第一个作为中轴
        sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_MIDDLE, low, low);
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_JUMP, high, high);
                high--;
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CURRENT, high, high);
            }
            numbers[low] = numbers[high];// 比中轴小的记录移到低端
            sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CURRENT, low, high);
            while (low < high && numbers[low] < temp) {
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_JUMP, low, low);
                low++;
                sortViewPresenter.addOrder(OrderModel.TYPE_COLOR, RectModel.COLOR_CURRENT, low, low);
            }
            numbers[high] = numbers[low]; // 比中轴大的记录移到高端
            sortViewPresenter.addOrder(OrderModel.TYPE_EXCHANGE, RectModel.COLOR_CURRENT, low, high);
        }
        numbers[low] = temp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }

    // 归并排序
    private int[] merageSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            merageSort(nums, low, mid);
            // 右边
            merageSort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
