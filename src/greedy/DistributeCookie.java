package greedy;

import java.util.Arrays;

public class DistributeCookie {
    public static void main(String[] args) {
        int[] g = {7,11};
        int[] s = {1,3,5,9,10};

        int ans = distributeCookie(g,s);
        System.out.println(ans);
    }
    public static int distributeCookie(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        //贪心算法，每次取最大的饼干去满足胃口最大的孩子
        int result = 0;//满足的孩子数量
        for (int i = g.length-1; i >=0 ; i--) {
            int index = s.length-1;//表示孩子数组的下标
            if(index>=0 && s[index] >= g[i]){
                result++;
                index--;
            }
        }
        return result;
    }
}