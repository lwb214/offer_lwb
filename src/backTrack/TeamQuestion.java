package backTrack;

import java.util.*;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
*/
public class TeamQuestion {
    //每一次的结果
    static LinkedList<Integer> path = new LinkedList<>();
    //输出结果集
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        int n = 7;
        int k = 3;
        team(n,k,1);
        System.out.println(result);
    }
    public static List<List<Integer>> team(int n,int k,int start){
        backTracking(n, k, start);
        return result;
    }
    public static void backTracking(int n,int k,int start){
        //当每次的结果等于k时，收集结果
        if(path.size() == k){
            //收集结果
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=n;i++){
            path.add(i);
            //每次回溯+1
            backTracking(n, k, i+1);
            //将本次结果弹出，放下一次的结果
            path.removeLast();
        }
    }
}
