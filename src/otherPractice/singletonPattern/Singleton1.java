package otherPractice.singletonPattern;
//单例模式的几种写法
public class Singleton1{
    //懒汉式
    //只有第一次调用get方法的时候，才去创建对象【多线程下，会出现导致多个线程同时创建对象，破坏单例】双重检查锁
    private static Singleton1 lazyMan;
    private Singleton1(){};
    public static Singleton1 getSingleton(){
        if (lazyMan == null){
            synchronized (Singleton1.class){
                if (lazyMan == null){
                    lazyMan = new Singleton1();
                }
            }
        }
        return lazyMan;
    }
}
