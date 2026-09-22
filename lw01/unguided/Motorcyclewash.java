package lw01.unguided;

public class Motorcyclewash extends Washservice {

    public Motorcyclewash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        return (getDays() * 15000) + 5000;
    }

    @Override
    public String label() {
        return "Motorcycle";
    }
}