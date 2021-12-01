public class SingletonDemo {
    public static void main(String[] args) {
        Singleton hw = Singleton.getSingletonInstance();
        hw.str = "hello world";
        System.out.println("Hello I am a singleton! Let me say " + hw.str + " to you");
    }
}

class Singleton{
    public String str = "";
    private static Singleton singleton = null;
    private Singleton() {}
    public static Singleton getSingletonInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
