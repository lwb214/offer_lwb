package otherPractice.ManyThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Sushi {
    /*在自助寿司店中，有1个寿司厨师，3个食客，厨师不断地做寿司并放到转盘上，转盘上最多能放10个寿司，一旦放满厨师就会休息10秒然后再次尝试制作放到转盘，
    每位食客每秒吃掉一个寿司(不考虑吃饱的情况)，如果转盘上没有寿司就会休息10秒后再次尝试吃.请以面向对象的编程思想，抽象上面的内容为生产者消费者模式编码。
    要求使用多线程实现(可以用线程池，也可以不用*/
    //转盘的最大容量10
    public static void main(String[] args) throws InterruptedException {
        EnjoySpace enjoySpace = new EnjoySpace();
        Thread cook = new Cook(enjoySpace);
        Thread d1 = new Diners(enjoySpace);d1.setName("客人1");
        Thread d2 = new Diners(enjoySpace);d2.setName("客人2");
        Thread d3 = new Diners(enjoySpace);d3.setName("客人3");
        cook.start();
        d1.start();
        d2.start();
        d3.start();
    }

   static class EnjoySpace{
        static final int plateMax = 10;
        //当前寿司数量
        static AtomicInteger curNum = new AtomicInteger(0);

        public synchronized void make() throws InterruptedException {
            if (curNum.get() >= plateMax){
                System.out.println("转盘上寿司满了,厨师休息10秒" + System.currentTimeMillis());
                this.wait(1000 * 10);
            }else {
                curNum.incrementAndGet();
                System.out.println("厨师做一块寿司,做了"+ curNum.get());
                this.notifyAll();
            }
        }

        public synchronized void eat() throws InterruptedException {
            if (curNum.get() <= 0){
                System.out.println("没有寿司了" + Thread.currentThread().getName()+ "休息10秒" + System.currentTimeMillis());
                this.wait(1000 * 10);
            }else {
                curNum.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + "吃一块寿司,还剩" + curNum.get());
                Thread.sleep(1000);
                this.wait(1);
                this.notifyAll();
            }
        }
    }
   static class Cook extends Thread{
        private final EnjoySpace enjoySpace;
        Cook(EnjoySpace enjoySpace) {
            this.enjoySpace = enjoySpace;
        }

        @Override
        public void run(){
            try {
                produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        private void produce() throws InterruptedException {
            while (true){
                enjoySpace.make();
            }
        }
    }
   static class Diners extends Thread{
        private final EnjoySpace enjoySpace;
        public Diners(EnjoySpace enjoySpace){
            this.enjoySpace = enjoySpace;
        }
        @Override
        public void run(){
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        private void consume() throws InterruptedException {
            while (true){
                enjoySpace.eat();
            }
        }
    }

}

