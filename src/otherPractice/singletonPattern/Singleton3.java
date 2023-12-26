package otherPractice.singletonPattern;

public class Singleton3 {
    //懒汉式
    private static  final  Singleton3 instance = new Singleton3();
    private Singleton3(){}

    public Singleton3 getInstance(){
        return instance;
    }
}
