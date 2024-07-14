package DesignPattern.AdapterDP;

public class Main {

    public static void main(String[] args) {

//        charger4s.charge();
//        Iphone4s iphone4s = new Iphone4s(new Iphone4sCharger());
//        iphone4s.onCharge();

        Iphone6s iphone6s = new Iphone6s(new Iphone6sTo4sAdapter(new Iphone4sCharger()));
        iphone6s.onCharge();
//        charger6s.charge();
    }
}
