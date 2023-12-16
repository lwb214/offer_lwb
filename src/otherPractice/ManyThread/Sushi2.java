package otherPractice.ManyThread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Sushi2 {
    /*在自助寿司店中，有1个寿司厨师，3个食客，厨师不断地做寿司并放到转盘上，转盘上最多能放10个寿司，一旦放满厨师就会休息10秒然后再次尝试制作放到转盘，
     每位食客每秒吃掉一个寿司(不考虑吃饱的情况)，如果转盘上没有寿司就会休息10秒后再次尝试吃.请以面向对象的编程思想，抽象上面的内容为生产者消费者模式编码。
     要求使用多线程实现(可以用线程池，也可以不用*/
    //转盘的最大容量10
    static int zhuanpanMax = 10;
    //当前寿司数量
    static AtomicInteger curNum = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        //线程池做法
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,7,30, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        Cook cook = new Cook();
        Diners d1 = new Diners("客人1");
        Diners d2 = new Diners("客人2");
        Diners d3 = new Diners("客人3");
        pool.submit(cook);pool.submit(d1);pool.submit(d2);pool.submit(d3);
        pool.shutdown();
    }
    static class Cook implements Runnable{
        public void make(){
            curNum.incrementAndGet();
            System.out.println("厨师做一块寿司,已经做了"+ curNum.get());
        }
        @Override
        public void run(){
               while (true){
                   if ( curNum.get() == zhuanpanMax){
                       try {
                           System.out.println("转盘上寿司满了,休息10秒" + System.currentTimeMillis());
                           Thread.sleep(1000 * 10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }else {
                       make();
                   }
               }
        }
    }
    static class Diners implements Runnable{
        String username;
        public Diners(String username) {
            this.username = username;
        }
        public void eat() throws InterruptedException {
            System.out.println(username + "吃一块寿司,还剩" + curNum.get() );
            curNum.decrementAndGet();
            Thread.sleep(1000);
        }
        @Override
        public void run(){
                while (true){
                    if (curNum.get() <= 0){
                        System.out.println("没有寿司了,休息10秒" + System.currentTimeMillis());
                        try {
                            Thread.sleep(1000 * 10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        try {
                            eat();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}

