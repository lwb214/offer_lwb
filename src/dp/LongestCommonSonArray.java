package dp;
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度
*/
public class LongestCommonSonArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,7,8};
        int[] B = {2,3,5,7,8};
        int result = longestCommonSonArray(A,B);
        System.out.println("两个数组最最大公共长度为："+result);
    }
    private static int longestCommonSonArray(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        //dp数组含义：以下标i-1结束的A，和以下标j-1结束的B，两者的最大重复子数组长度
        //递推公式为：dp的每一项都是由前一项加一得来dp[i][j] = dp[i-1][j-1]+1;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
