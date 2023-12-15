package character;

import java.util.Scanner;

public class Time {
    //时间轮盘
    /*例如：
           输入一个时间23:23
    *      输入一个数字 表示数组的长度 2
    *      输入数组的元素“注意中间有空格”
    *      + 5
    *      + 20
    * 输出：23:48
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        int count = 0;
        while (n > 0){
            String str  = sc.nextLine();
            String[] strs = str.split(" ");
            String fuhao = strs[0];
            String number = strs[1];
            if(fuhao.equals("+")){
                count += Integer.parseInt(number);
            }else{
                count -= Integer.parseInt(number);
            }
            n--;
        }
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        min += count;
        if(min >= 60){
            hour += min/60;
            min %= 60;
            if(hour >= 24){
                hour %= 24;
            }
        } else if (min < 0) {
            int temp = min/60-1;
            hour += temp;
            min -= temp * 60;
            if (hour < 0){
                hour += 24;
            }
        }
        StringBuilder sb = new StringBuilder();
        //拼接时间
        if(hour < 10)   sb.append(0).append(hour);
        else   sb.append(hour);
        //拼接分隔符
        sb.append(":");
        //拼接分钟
        if (min < 10)   sb.append(0).append(min);
        else sb.append(min);
        System.out.println(sb.toString());
    }
}
