package greedy;

public class MaxSuborderSum {
    public static void main(String[] args) {
        int [] num = {2,-1,-3,4,-1,3,2,-7};
        int ans = maxSuborderSum(num);
        System.out.println(ans);
    }
    //贪心思想
    public static int maxSuborderSum(int[] num){
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i <num.length ; i++) {
            count += num[i];
            sum = Math.max(sum,count);
            //如果数组的子序和为负数或0，就将子序和清零
            if(count <= 0){
                count = 0;
            }
        }
        return sum;
    }
}