package backTrack;

import java.util.*;

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字*/
public class TeamQuestion2 {
    //每一次的结果
    static LinkedList<Integer> path = new LinkedList<>();
    //输出结果集
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        int n = 9;
        int k = 3;
        team(n,k,1,0);
        System.out.println(result);
    }
    public static List<List<Integer>> team(int n,int k,int start,int sum){
        backTracking(n, k, start,sum);
        return result;
    }
    public static void backTracking(int n,int k,int start,int sum){
        if(sum > n || path.size() > k){
            return;
        }
        //当每次的结果等于k时，收集结果
        if(path.size() == k && sum == n){
            //收集结果
            result.add(new ArrayList<>(path));
            //清空sum
            sum = 0;
            return;
        }
        for(int i=start;i<=9;i++){
            sum += i;
            path.add(i);
            //每次回溯+1
            backTracking(n, k, i+1,sum);
            //将本次结果弹出，放下一次的结果(回溯)
            path.removeLast();
            //回溯
            sum -= i;
        }
    }
}
