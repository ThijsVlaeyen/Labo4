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
        String out = "";
        out += "AccountLogger:\nAmount of accounts:\t" + bank.getAccounts().size() + "\n";
        out += "New account number:\t" + a.getAccountNumber() + "\n";
        System.out.println(out);
    }

    @Override
    public void update(Account a) {
        this.a = a;
        display();
    }
}
