package otherPractice;

import java.util.*;
public class MoreThanHalfNum{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] array = new int[number];
        for (int i = 0; i <number ; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        int answer = MoreThanHalfNum_Solution(array);
        System.out.println(answer);
    }

    private static int MoreThanHalfNum_Solution(int[] numbers) {
        //哈希表
        HashMap<Integer,Integer> mp = new HashMap<>();
        //遍历数组
        for(int i=0;i<numbers.length;i++){
            if(!mp.containsKey(numbers[i])){
                mp.put(numbers[i],1);
            }else{
                mp.put(numbers[i],mp.get(numbers[i]) + 1);
            }
            if(mp.get(numbers[i]) > numbers.length/2){
                return numbers[i];
            }
        }
        return 0;
    }
}