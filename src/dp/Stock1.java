package dp;

public class Stock1 {
    /*
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
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
        int num = stock1(arr);
        System.out.println(num);
    }
    public static int stock1(int[] price){
        //dp数组[i][0]表示第i天不持有股票的最大金额
        //dp数组[i][1]表示第i天持有股票的最大金额
        int n = price.length;
        int[][] dp = new int[n][2];
        //为什么是负的price，因为初始的金额是0，第一天买了股票，金额就为负数
        dp[0][0] = 0;
        dp[0][1] = -price[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + price[i]);
            dp[i][1] = Math.max(dp[i-1][1],-price[i]);
        }
        //当然将股票卖出的金额大啦，所以输出dp[i][0]
        return dp[n-1][0];
    }
}
