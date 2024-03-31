package backTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串
返回 s 所有可能的分割方案。
示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
*/
public class CutCharacter {
    static List<List<String>> list = new ArrayList<>();
    static Deque<String> path = new LinkedList<>();
    public static void main(String[] args) {
        String str = "aab";
        common(str);
        System.out.println(list);
    }
    //回溯入口
    public static List<List<String>> common(String tar){
        backTracking(tar,0);
        return list;
    }
    //回溯核心
    public static void backTracking(String tar,int start){
        if(start > tar.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<tar.length();i++){
            if(isPalindrome(tar, start,i)){
                String str = tar.substring(start,i+1);
                path.addLast(str);
            }else  continue;
            //递归，起始位置右移
            backTracking(tar, start+1);
            //回溯
            path.removeLast();
        }
    }
    //判断是否回文
    public static boolean isPalindrome(String tar,int start,int end){
        int j = end;
        for(int i=start;i<j;i++){
            if(tar.charAt(i) != tar.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
}
