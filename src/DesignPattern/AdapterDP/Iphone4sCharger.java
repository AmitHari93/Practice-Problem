package DesignPattern.AdapterDP;

public class Iphone4sCharger implements Charger{
    @Override
    public void charge() {
        System.out.println("Charging using Iphone4s charger!");
    }
}
