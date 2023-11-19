package array;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {2,4,6,8,34,45,57,67,77,88,90,123};
        int ans = binarySearch(arr,67);
        System.out.println(ans);
    }
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int middle = (left + right)/2;
            if(arr[middle] > target){
                right = middle - 1;
            } else if (arr[middle] < target) {
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}