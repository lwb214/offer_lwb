package dp;

public class Stock3 {
    /*
    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
    输入：prices = [3,3,5,0,0,3,1,4]
    输出：6
    解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3。
     */
    public static void main(String[] args) {
        //        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] arr0 = str.split(" ");
//        int[] arr = new int[arr0.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(arr0[i]);
//        }
        int[] arr = {7,1,5,3,6,4};
        int[] arr1  = {3,3,5,0,0,3,1,4};
        int[] arr2 = {1,2,3,4,5};
        int result = stock3(arr2);
        System.out.println(result);
    }
    public static int stock3(int[] price){
        int n = price.length;
        int[][] dp = new int[n][5];
        /*
        定义5种状态 0无操作 1第一次买入 2第一次卖出 3第二次买入 4 第二次卖出
         */
        dp[0][1] = -price[0];
        dp[0][3] = -price[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i-1][1], -price[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + price[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - price[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + price[i]);
        }
        return dp[n-1][4];
    }
}
