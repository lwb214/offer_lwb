package array;

import java.util.Arrays;
import java.util.Scanner;

//全排列
public class FullPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        Integer[] arr = new Integer[strs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        perm(arr,0, arr.length-1);
    }
    public static void perm(Integer[] arr,int start,int end){
        if (start == end){
            System.out.println(Arrays.toString(arr));
        }else {
            for (int i = start; i <= end ; i++) {
                swap(arr,start,i);
                perm(arr,start+1,end);
                swap(arr,start,i);
            }
        }
    }
    public static void swap(Integer[] arr,int i ,int j){
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
