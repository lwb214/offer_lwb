package backTrack;

import java.util.*;
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
*/
public class MonogramOfPhoneNumber {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String tar = "23";
        //按键对应字母数组
        String[] nums ={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combination(tar, nums);
        combination(tar, nums);
        System.out.println(list);
    }
    static StringBuilder sb = new StringBuilder();
    public static List<String> combination(String tar,String[] nums){
        if(tar.length() == 0 || tar == null){
            return list;
        }
        backTracking(tar, nums,0);
        return list;
    }
    public static void backTracking(String tar,String[] nums,int num){
        //当每一次的结果的长度==按键长度，收集结果
        if(tar.length() == sb.length()){
            list.add(sb.toString());
            return;
        }
        //按键的第num个数字对应的字母
        String str = nums[tar.charAt(num) - '0'];
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            //递归下一个按键
            backTracking(tar, nums, num+1);
            //删除末尾的字符（回溯）
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
