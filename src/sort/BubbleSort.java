package sort;

import java.util.ArrayList;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 32, 3, 6, 8, 14, 2, 55, 21, 32, 1};

        bubbleSort(arr);
//        bubbleSortUpGrade(arr);
        ArrayList ans = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
        }
        System.out.println(ans);
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1 ; j++) {
                if(arr[j] > arr[j+1]){//如果前一位大于后一位，则交换
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    //优化后的冒泡排序
    public static void bubbleSortUpGrade(int[] arr){
        boolean flag  = false;//判断是否进行过交换
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){//如果前一位大于后一位，则交换
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;//发生交换则标记为true
                }
            }
            //如果它没有进行交换，说明已经有序，退出循环即可
            //如果它进行了交换，就把它置为false，判断下一次是否发生交换
            if(flag == false)
                break;
            else
                flag = false;
        }
    }
}
