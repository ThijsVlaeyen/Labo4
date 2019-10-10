package domain;

public class Auditor implements Observer,Console {
    private Account a;

    @Override
    public void update(Account a) {
        this.a = a;
    }

    @Override
    public void display() {
        System.out.println(a.toString());
    }
}
