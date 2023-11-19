package otherPractice;

import java.util.*;
public class MergeArray {
    public static void main(String[] args) {
        int[] a1 = {7,5,6,2,8,2,9,2,8,2,5,5,5,2,5,41};
        int[] a2 = {6,6,4,126,1,50,0,0,1};
        List list = Merge(a1,a2);
        Collections.sort(list);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +",");
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }
        }
        System.out.print("]");
    }
    public static List<Integer> Merge(int[] a1,int[] a2){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a1.length ; i++) {
            list.add(a1[i]);
        }
        for (int i = 0; i < a2.length ; i++) {
            list.add(a2[i]);
        }
        return list;
    }
}
