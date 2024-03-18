package character;

import java.util.Scanner;
/*
    反转字符串
    输入：君不见黄河之水天上来
    输出：来上天水之河黄见不君
 */
public class ReverseCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "君不见黄河之水天上来";
        System.out.println("原字符串： "+str);
        StringBuilder sb = reverse(str);
        System.out.println("反转后字符串："+sb);
    }
    static StringBuilder reverse(String arr){
            int n = arr.length();
            //用StringBuffer编辑字符串
            //双指针解法，左右两边各一个指针，进行交换
            StringBuilder sb  =new StringBuilder(arr);
        for (int i = 0,j = n-1; i < n/2; i++,j--) {
            char  temp = arr.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
        }
        return sb;
    }
}
