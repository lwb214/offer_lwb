package character;
/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
示例 2: 输入: s = "rat", t = "car" 输出: false*/
public class HeterotopicWords {
    public static void main(String[] args) {
        String s = "aoubt";
        String t = "aboup";
        boolean result = isNotSame(s, t);
        System.out.println(result);
    }
    public static boolean isNotSame(String s,String t){
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            count[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
