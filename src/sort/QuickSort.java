package sort;

import java.util.ArrayList;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 32, 3, 6, 8, 14, 2, 55, 21, 32, 1};
        quickSort(arr, 0, arr.length - 1);
        ArrayList ans = new ArrayList();
        for (int j : arr) {
            ans.add(j);
        }
        System.out.println(ans);
    }
    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {//左指针大于右指针，停止
            return;
        }
        int i = left;
        int j = right;
        int base = arr[left];//定义基准
        while (i < j) {
            while (base <= arr[j] && i < j) {//从右往左，找小于基准的数
                j--;
            }
            while (base >= arr[i] && i < j) {//从左往右，找大于基准的数
                i++;
            }
            if (i < j) {//满足条件，交换
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;//将基准归位
        //此时i，j相遇
        quickSort(arr, left, i - 1);//递归调用左子数组
        quickSort(arr, i + 1, right);//递归调用右子数组
    }
}
