package com.example.lib;

public class myClass {
    public static void main(String arg[]) {
        int[] array = {5, 2, 8, 9, 1, 3, 4};
        bubbleSort(array);
        for (int i : array) {
            System.out.print(i);
        }
    }
    //冒泡排序
    private static void bubbleSort(int[] array){
        int length = array.length;
        int temp = 0;
        boolean flag = true;
        for (int i=0;i<length-1&flag;i++){
            flag = false;
            for (int j = 0; j<length-1-i; j++){
                if (array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

    //归并排序
    private static void sort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] nums = new int[right - left + 1];
        int k = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            nums[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            nums[k++] = array[i++];
        }
        while (j <= right) {
            nums[k++] = array[j++];
        }
        System.arraycopy(nums, 0, array, left, nums.length);
    }
}
