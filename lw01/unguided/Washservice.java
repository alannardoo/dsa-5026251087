package lw01.unguided;

public abstract class Washservice implements Billable {
    private String id;
    private int days;

    protected Washservice(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days can't be negative or zero!");
        }
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return this.id;
    }

    public int getDays() {
        return this.days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Units must be positive");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Service";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }

    public String summary(int units) {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}