package otherPractice;

import java.util.Scanner;

public class In {
    //输入并且输出一个二维数组
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] array = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j] = sc.nextInt();
            }
        }
        sc.close();

        for(int i=0;i<m;i++){//矩阵按行打出
            for(int j=0;j<n;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

}
