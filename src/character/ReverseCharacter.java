package character;

import java.util.Scanner;
/*
    反转字符串
    输入：a b c d e f g
    输出：g f e d c b a
 */
public class ReverseCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        reverse(arr);
        for (String s:arr) {
            System.out.print(s + " ");
        }
    }
    static void reverse(String[] arr){
            int n = arr.length;
        for (int i = 0,j = n-1; i < n/2; i++,j--) {
            String temp;
           temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
        }
    }
}
