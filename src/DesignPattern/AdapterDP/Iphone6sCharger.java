package DesignPattern.AdapterDP;

public class Iphone6sCharger implements Charger{
    @Override
    public void charge() {
        System.out.println("Charging using Iphone6s charger!");
    }
}
