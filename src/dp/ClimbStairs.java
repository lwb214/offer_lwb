package dp;

import java.util.Scanner;

public class ClimbStairs {
    /*
    爬楼梯，一次可以爬一节楼梯，也可以爬两节楼梯
    问：爬n节楼梯有多少种办法
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = climbStairs(n);
        System.out.println(result);
    }
    public static int climbStairs(int n){
        //第i节楼梯，有dp[i]种办法
        int[] dp = new int[n+1];
        dp[1] = 1;dp[2] = 2;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
