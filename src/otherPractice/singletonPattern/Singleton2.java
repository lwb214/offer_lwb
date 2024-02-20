package otherPractice.singletonPattern;

public class Singleton2 {
    //静态内部类
    public static class HungryMan{
        private static Singleton2 hungryMan = new Singleton2();
    }
    public Singleton2 singleton2(){
        return HungryMan.hungryMan;
    }
}
