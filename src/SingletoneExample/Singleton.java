package SingletoneExample;

public class Singleton {

    private static Singleton singletoneIntance;

    private Singleton(){
        System.out.println("singleton class constructor getting called.");
    }

    public static synchronized Singleton getInstance(){
        if (singletoneIntance == null){
            singletoneIntance = new Singleton();
        }
        return singletoneIntance;
    }
}
