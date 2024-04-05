package backTrack;

import java.util.*;
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
说明：解集不能包含重复的子集
示例: 输入: nums = [1,2,3]
     输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
*/
public class SubsetQuestion {
    //每一次的结果
    static LinkedList<Integer> path = new LinkedList<>();
    //输出结果集
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        int[] nums = {1,3};
        team(nums,0);
        System.out.println(result);
    }
    public static List<List<Integer>> team(int[] nums,int start){
        backTracking(nums, start);
        return result;
    }
    public static void backTracking(int[] nums,int start){
        //子集问题要收集每次的结果
        result.add(new ArrayList<>(path));
        //终止条件（终止条件可不加）
        if(start > path.size()){
            return;
        }
        for(int i=start;i<nums.length;i++){
            path.add(i);
            //每次回溯+1
            backTracking(nums,start+1);
            //将本次结果弹出，放下一次的结果
            path.removeLast();
        }
    }
}
