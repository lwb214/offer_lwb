package backTrack;

import java.util.*;
/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
输入: [1,2,3]
输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
*/
public class FullyArrange {
    //每一次的搜索子集
    static LinkedList<Integer> path = new LinkedList<>();
    //输出结果集
    static List<List<Integer>> result = new ArrayList<>();
    //代表元素是否被使用过
    static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        int[] nums = {1,2};
        team(nums,0);
        System.out.println(result);
    }
    public static List<List<Integer>> team(int[] nums,int start){
        used = new boolean[nums.length];
        backTracking(nums, start);
        return result;
    }
    public static void backTracking(int[] nums,int start){
        //当子集与数组大小相等时，收集结果
        if(path.size() == nums.length){
            //收集结果
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //若此时元素已经被使用，则下一次循环
            if(used[i] == true){
                continue;
            }
            //使用前将元素标记为使用
            used[i] = true;
            path.add(nums[i]);
            //每次回溯+1（递归下一个）
            backTracking(nums, start+1);
            //将本次结果弹出，放下一次的结果
            path.removeLast();
            //回溯used为false
            used[i] = false;
        }
    }
}
