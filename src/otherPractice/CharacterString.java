package otherPractice;
import java.util.*;
public class CharacterString {
    /*
    输入两组字符串，将第一组出现的第二组所有字符进行删除，输出删除后的字符串【第一行有空格】
    例：
    输入：you are beautiful!
         aeiou
    输出：y r btfl!
    */
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            //修改Scanner的默认结束符
            sc.useDelimiter("/n");
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            StringBuffer sb = new StringBuffer(str1);
            for(int i = 0; i < str2.length(); i++)
            {
                for(int j = 0; j < sb.length(); j++)
                {
                    if(str2.charAt(i) == sb.charAt(j))
                    {
                        sb.deleteCharAt(j);
                    }
                }
            }
            System.out.println(sb.toString());
        }
}
