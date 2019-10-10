package domain;

public class Auditor implements Observer,Console {
    private Account a;
    private Bank bank;

    public Auditor(Bank bank) {
        this.bank = bank;
        bank.registerObserver(this);
    }

    @Override
    public void update(Account a) {
        this.a = a;
        display();
    }

    @Override
    public void display() {
        System.out.println(a.toString());
    }
}
