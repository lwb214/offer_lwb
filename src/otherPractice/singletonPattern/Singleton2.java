package otherPractice.singletonPattern;

public class Singleton2 {
    //静态内部类

    private Singleton2(){}
    private static class HungryMan{
        private static Singleton2 hungryMan = new Singleton2();
    }
    public Singleton2 getSingleton(){
        return HungryMan.hungryMan;
    }
}
