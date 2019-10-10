package domain;

public class Accountlogger implements Observer, Console {
    private Bank bank;
    private Account a;

    public Accountlogger(Bank bank)
    {
        this.bank = bank;
        bank.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(a.toString());
    }

    @Override
    public void update(Account a) {
        this.a = a;
        display();
    }
}
