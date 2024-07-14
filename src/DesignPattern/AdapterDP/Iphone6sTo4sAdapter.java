package DesignPattern.AdapterDP;

public class Iphone6sTo4sAdapter implements Charger{
    Iphone4sCharger iphone4sCharger;

    public Iphone6sTo4sAdapter(Iphone4sCharger iphone4sCharger){
        this.iphone4sCharger = iphone4sCharger;
    }
    @Override
    public void charge() {
        iphone4sCharger.charge();
    }
}
