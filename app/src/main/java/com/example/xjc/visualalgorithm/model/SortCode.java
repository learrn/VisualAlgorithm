package com.example.xjc.visualalgorithm.model;

public class SortCode {
    public static final String SORT_ID = "sortId";
    public static final int BUBBLE_SORT = 0;
    public static final int SELECT_SORT = 1;
    public static final int INSERT_SORT = 2;
    public static final int SHELL_SORT = 3;
    public static final int HEAP_SORT = 4;
    public static final int QUICK_SORT = 5;
    public static final int MERGE_SORT = 6;

    public static final String CODE_BUBBLE =
            "public static void bubbleSort(int[] numbers) {\n" +
                    "    int temp = 0;\n" +
                    "    int size = numbers.length;\n" +
                    "    boolean flag = true;\n" +
                    "    for (int i = 0; i < size - 1&&flag; i++) {\n" +
                    "        flag = false;\n" +
                    "        for (int j = 0; j < size - 1 - i; j++) {\n" +
                    "            if (numbers[j] > numbers[j + 1]) // 交换两数位置\n" +
                    "            {\n" +
                    "                temp = numbers[j];\n" +
                    "                numbers[j] = numbers[j + 1];\n" +
                    "                numbers[j + 1] = temp;\n" +
                    "                flag = true;\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";

    public static final String CODE_SELECT =
            "public static void selectSort(int[] numbers) { \n" +
                    "    int size = numbers.length; // 数组长度\n" +
                    "    int temp = 0;  // 中间变量\n" +
                    "    for (int i = 0; i < size - 1; i++) {\n" +
                    "        int k = i; // 待确定的位置\n" +
                    "        // 选择出应该在第i个位置的数 \n" +
                    "        for (int j = i + 1; j < size; j++) {\n" +
                    "            if (numbers[j] < numbers[k]) {\n" +
                    "                k = j;\n" +
                    "            }\n" +
                    "        }\n" +
                    "        // 交换两个数 \n" +
                    "        temp = numbers[i];\n" +
                    "        numbers[i] = numbers[k];\n" +
                    "        numbers[k] = temp;\n" +
                    "    }\n" +
                    " }\n";

    public static final String CODE_INSERT =
            "public static void insertSort(int[] numbers) {" +
                    "    int size = numbers.length;\n" +
                    "    int temp = 0; \n" +
                    "    int j = 0;\n" +
                    "    for (int i = 1; i < size; i++) {\n" +
                    "        temp = numbers[i];\n" +
                    "        // 假如temp比前面的值小，则将前面的值后移 \n" +
                    "        for (j = i; j > 0 && temp < numbers[j - 1]; j--) {\n" +
                    "            numbers[j] = numbers[j - 1];\n" +
                    "        }\n" +
                    "        numbers[j] = temp;\n" +
                    "    }\n" +
                    "}\n";

    public static final String CODE_SHELL =
            "public static void shellSort(int[] data) {\n" +
                    "    int j = 0;\n" +
                    "    int temp = 0;\n" +
                    "    // 每次将步长缩短为原来的一半\n" +
                    "    for (int increment = data.length / 2; increment > 0; increment /= 2) {\n" +
                    "        for (int i = increment; i < data.length; i++) {\n" +
                    "            temp = data[i];\n" +
                    "            for (j = i; j >= increment; j -= increment) {\n" +
                    "                if (temp < data[j - increment])\n" +
                    "                {\n" +
                    "                    data[j] = data[j - increment];\n" +
                    "                } else {\n" +
                    "                    break;\n" +
                    "                }\n" +
                    "            }\n" +
                    "            data[j] = temp;\n" +
                    "        }\n" +
                    "    }";

    public static final String CODE_HEAP =
            "public static void heapSort(int[] a){\n" +
            "    int arrayLength = a.length;\n" +
            "    // 循环建堆\n" +
            "    for (int i = 0; i < arrayLength - 1; i++) {\n" +
            "        // 建堆\n" +
            "        buildMaxHeap(a, arrayLength - 1 - i);\n" +
            "        // 交换堆顶和最后一个元素\n" +
            "        swap(a, 0, arrayLength - 1 - i);\n" +
            "        System.out.println(Arrays.toString(a));\n" +
            "    }\n" +
            "}\n" +
            "// 对data数组从0到lastIndex建大顶堆\n" +
            "public static void buildMaxHeap(int[] data, int lastIndex) {\n" +
            "    // 从lastIndex处节点（最后一个节点）的父节点开始\n" +
            "    for (int i = (lastIndex - 1) / 2; i >= 0; i--) {\n" +
            "        // k保存正在判断的节点\n" +
            "        int k = i;\n" +
            "        // 如果当前k节点的子节点存在\n" +
            "        while (k * 2 + 1 <= lastIndex) {\n" +
            "            // k节点的左子节点的索引\n" +
            "            int biggerIndex = 2 * k + 1;\n" +
            "            // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在\n" +
            "            if (biggerIndex < lastIndex) {\n" +
            "                // 若果右子节点的值较大\n" +
            "                if (data[biggerIndex] < data[biggerIndex + 1]) {\n" +
            "                    // biggerIndex总是记录较大子节点的索引\n" +
            "                    biggerIndex++;\n" +
            "                }\n" +
            "            }\n" +
            "            // 如果k节点的值小于其较大的子节点的值\n" +
            "            if (data[k] < data[biggerIndex]) {\n" +
            "                // 交换他们\n" +
            "                swap(data, k, biggerIndex);\n" +
            "                // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值\n" +
            "                k = biggerIndex;\n" +
            "            } else {\n" +
            "                break;\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "// 交换\n" +
            "private static void swap(int[] data, int i, int j) {\n" +
            "    int tmp = data[i];\n" +
            "    data[i] = data[j];\n" +
            "    data[j] = tmp;\n" +
            "}";

    public static final String CODE_QUICK =
            "public static void quick(int[] numbers) {\n" +
                    "    if (numbers.length > 0) // 查看数组是否为空\n" +
                    "    {\n" +
                    "        quickSort(numbers, 0, numbers.length - 1);\n" +
                    "    }" +
                    "public static void quickSort(int[] numbers, int low, int high) {\n" +
                    "    if (low >= high) {\n" +
                    "        return;\n" +
                    "    }\n" +
                    "    int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二\n" +
                    "    quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序\n" +
                    "    quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序\n" +
                    "}\n" +
                    "\n" +
                    "public static int getMiddle(int[] numbers, int low, int high) {\n" +
                    "    int temp = numbers[low]; // 数组的第一个作为中轴\n" +
                    "    while (low < high) {\n" +
                    "        while (low < high && numbers[high] > temp) {\n" +
                    "            high--;\n" +
                    "        }\n" +
                    "        numbers[low] = numbers[high];// 比中轴小的记录移到低端\n" +
                    "        while (low < high && numbers[low] < temp) {\n" +
                    "            low++;\n" +
                    "        }\n" +
                    "        numbers[high] = numbers[low]; // 比中轴大的记录移到高端\n" +
                    "    }\n" +
                    "    numbers[low] = temp; // 中轴记录到尾\n" +
                    "    return low; // 返回中轴的位置\n" +
                    "}";

    public static final String CODE_MERGE =
            "public static void merge(int[] nums, int low, int mid, int high) {\n" +
                    "    int[] temp = new int[high - low + 1];\n" +
                    "    int i = low;// 左指针\n" +
                    "    int j = mid + 1;// 右指针\n" +
                    "    int k = 0;\n" +
                    "    while (i <= mid && j <= high) {\n" +
                    "        if (nums[i] < nums[j]) {\n" +
                    "            temp[k++] = nums[i++];\n" +
                    "        } else {\n" +
                    "            temp[k++] = nums[j++];\n" +
                    "        }\n" +
                    "    }\n" +
                    "    while (i <= mid) {\n" +
                    "        temp[k++] = nums[i++];\n" +
                    "    }\n" +
                    "    while (j <= high) {\n" +
                    "        temp[k++] = nums[j++];\n" +
                    "    }\n" +
                    "    for (int k2 = 0; k2 < temp.length; k2++) {\n" +
                    "        nums[k2 + low] = temp[k2];\n" +
                    "    }\n" +
                    "}";

}
