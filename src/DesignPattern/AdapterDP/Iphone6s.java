package DesignPattern.AdapterDP;

public class Iphone6s implements Iphone{
//    Iphone6sCharger iphone6sCharger;
//
//    public Iphone6s(Iphone6sCharger iphone6sCharger){
//        this.iphone6sCharger = iphone6sCharger;
//    }
    Iphone6sTo4sAdapter iphone6sTo4sAdapter;

    public Iphone6s(Iphone6sTo4sAdapter iphone6sTo4sAdapter){
        this.iphone6sTo4sAdapter = iphone6sTo4sAdapter;
    }

    @Override
    public void onCharge() {
        iphone6sTo4sAdapter.charge();
    }
}
