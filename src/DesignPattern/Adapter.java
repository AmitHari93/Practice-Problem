package DesignPattern;

public class Adapter implements IphoneCharger{
    ACharger aCharger;

    public Adapter(ACharger aCharger){
        this.aCharger=aCharger;
    }

    @Override
    public void chargeIphone() {
        aCharger.chargeAndroidPhone();
        System.out.println("I phone is charging with adapter.");
    }
}
