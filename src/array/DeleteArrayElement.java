package array;

public class DeleteArrayElement{
    //删除数组中指定元素，返回新数组大小
    public static void main(String[] args) {
        int[] num = {6,4,4,6,6,9,1,17};
        int ans = deleteArrayElement(num,4);
        System.out.println(ans);
    }
    public static int deleteArrayElement(int[] arr,int element){
        //双指针解法
        //快指针遍历数组元素
        //慢指针表示数组下标
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if(arr[fast] != element){
                arr[slow]  = arr[fast];
                slow++;
            }
        }
        return slow;
    }
}