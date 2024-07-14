package DesignPattern;

public class Iphone{
    ICharger iCharger;

    public Iphone(ICharger iCharger){
        this.iCharger=iCharger;
    }

    void chargeIphone(){
        iCharger.chargeIphone();
    }
}
