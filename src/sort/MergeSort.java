package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0,50);
        }
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int start = 0;
        int end = arr.length-1;
        sortLoop(arr,start,end);
    }
    public static void sortLoop(int[] arr,int start,int end){
        if(start == end){
            return;
        }
        int mid = (start + end)/2;
        //递归两两拆分数组
        sortLoop(arr,start,mid);
        sortLoop(arr,mid+1,end);
        //两两合并数组
        merge(arr,start,mid+1,end);
    }
    public static int[] merge(int[] arr,int start,int start2,int end){
        int len1 = start2 - start;
        int [] temp = new int[len1];
        //将左数组赋值给临时数组
        System.arraycopy(arr,start,temp,0,len1);
        //左数组当前索引
        int p1 = 0;
        //右数组当前索引
        int p2 = start2;
        //合并左右数组
        for (int i = start; i <= end; i++) {
            if(temp[p1] <= arr[p2]){
                arr[i] = temp[p1];
                p1++;
            //左数组遍历完成，结束
                if(p1 == len1)
                    break;
            }else {
                arr[i] = arr[p2];
                p2++;
                //右数组合并完了，左数组没有合并完的情况，把左数组依次直接放到已经合并好的数组后面
                if(p2 > end){
                    while (p1 < len1){
                        i++;
                        arr[i] = temp[p1];
                        p1++;
                    }
                }
            }
        }
        return arr;
    }
}
