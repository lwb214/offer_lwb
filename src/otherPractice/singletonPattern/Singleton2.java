package otherPractice.singletonPattern;

public class Singleton2 {
    //饿汉式
    public static class HungryMan{
        public static Singleton2 hungryMan = new Singleton2();
    }
    public Singleton2 singleton2(){
        return HungryMan.hungryMan;
    }

}
