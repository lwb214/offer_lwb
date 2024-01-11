package character;
import java.util.Scanner;
/*
最长回文子串
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        String ans = "";
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                //找到每一个字串
                if (isPalindromic(str.substring(i,j)) && j-i > max){
                    max = j-i;
                    ans = str.substring(i,j);
                }
            }
        }
        System.out.println(ans);
    }
    //判断是否回文串
    private static boolean isPalindromic(String s){
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
