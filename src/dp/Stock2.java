package dp;

public class Stock2 {
    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票)
    输入: [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
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
        int[] arr1  = {1,2,3,5,6};
        int result = stock2(arr1);
        System.out.println(result);
    }
    public static int stock2(int[] price){
        int n = price.length;
        int[][] dp  = new int[n][2];
        //不持有股票
        dp[0][0] = 0;
        //持有股票
        dp[0][1] = -price[0];
        for (int i = 1; i < n; i++) {
            //不持有两种情况：1上一天也不持有，延续上一天状态 2上一天持有，将上一天持有状态的金额加上当天的股票价格
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + price[i]);
            //持有也有两种情况：1上一天也持有，延续上一天状态 2上一天不持有，将上一天不持有状态的金额减去当天的股票价格
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - price[i]);
        }
        //当然将股票卖出的金额大啦，所以输出dp[i][0]
        return dp[n-1][0];
    }
}
