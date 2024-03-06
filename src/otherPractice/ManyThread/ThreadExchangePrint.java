package otherPractice.ManyThread;
/*
三个线程交替打印线程ABC
 */
public class ThreadExchangePrint {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(new PrintABC(null),"A");
            Thread b = new Thread(new PrintABC(a),"B");
            Thread c = new Thread(new PrintABC(b),"C");
            a.start();
            b.start();
            c.start();
//            Thread.sleep(10);
        }
    }
    static class PrintABC implements Runnable{
        private Thread before;
        public PrintABC(Thread before){
            this.before = before;
        }
        @Override
        public void run() {
            if(before != null){
                try {
                    before.join();
                    System.out.print(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.print(Thread.currentThread().getName());
            }
        }
    }
}
