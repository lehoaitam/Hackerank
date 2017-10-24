package Design;

public class Singleton {
    public int value;
    private static Singleton instance;
    private Singleton(){

    }
    public static Singleton INSTANCE(){
        return SingletonHelper.INSTANCE;
    }
    private static class SingletonHelper{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static void main(String[] args){
        Singleton s1 = Singleton.INSTANCE();
        s1.value = 5;
        System.out.println(s1.value);

        Singleton s2 = Singleton.INSTANCE();
        s2.value = 6;
        System.out.println(s2.value);

        System.out.println(s1.value);

    }

}
