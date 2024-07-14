package DesignPattern;

public class Main {

    public static void main(String[] args) {

        //ICharger iCharger = new ICharger();
        ACharger aCharger = new ACharger();
        Adapter adapter = new Adapter(aCharger);
        //Iphone iphone = new Iphone(adapter);
        adapter.chargeIphone();


        Android android = new Android(aCharger);
        android.chargeAndroidPhone();

//        Iphone iphone = new Iphone();
//        iphone.charge();
    }
}
