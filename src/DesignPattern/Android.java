package DesignPattern;

public class Android{
    AndroidCharger charger;

    public Android(AndroidCharger charger){
        this.charger=charger;
    }

    void chargeAndroidPhone(){
        charger.chargeAndroidPhone();
    }
}
