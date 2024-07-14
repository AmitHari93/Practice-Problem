package DesignPattern.AdapterDP;

public class Iphone4s implements Iphone{
    Iphone4sCharger iphone4sCharger;

    public Iphone4s(Iphone4sCharger iphone4sCharger){
        this.iphone4sCharger = iphone4sCharger;
    }

    @Override
    public void onCharge() {
        iphone4sCharger.charge();
    }
}
