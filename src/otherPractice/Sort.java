package otherPractice;

import java.util.ArrayList;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {9, 5, 7, 32, 3, 6, 8, 14, 2, 55, 21, 32, 1};
//        sort.quickSort(arr, 0, arr.length - 1);
//        sort.bubbleSort(arr);
        sort.bubbleSort0(arr);
        ArrayList ans = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
        }
        System.out.println(ans);
    }
    //快速排序
    public void quickSort(int[] arr, int left, int right) {
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
    //冒泡排序
    public void bubbleSort0(int[] arr){
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
       public void bubbleSort(int[] arr){
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