package  sort;
public class ThreadLocalExample {

    // 创建ThreadLocal对象
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        // 定义线程本地变量并设置初始值
        threadLocal.set("Hello, World!");

        // 创建线程并启动
        Thread thread = new Thread(new MyRunnable());
        Thread thread1 = new Thread(new KKK());
        thread.start();
        thread1.start();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            // 获取线程本地变量的值
            String value = threadLocal.get();
            System.out.println("Thread Local Value: " + value);

            // 设置线程本地变量的值
            threadLocal.set("Hello, Thread!");
            String valueThread = threadLocal.get();
            System.out.println("Thread Local Value: " + valueThread);

            // 清理线程本地变量
            threadLocal.remove();
        }

    }
    static class KKK implements Runnable {

        @Override
        public void run() {
            // 获取线程本地变量的值
            String value = threadLocal.get();
            System.out.println("Thread Local Value: " + value);

            // 设置线程本地变量的值
            threadLocal.set("Hello, kkk!");
            String valueThread = threadLocal.get();
            System.out.println("Thread Local Value: " + valueThread);

            // 清理线程本地变量
            threadLocal.remove();
            System.out.println("Thread Local Value: " + threadLocal.get());
        }
    }
}
