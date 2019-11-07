package domain;

import java.util.Objects;

public class Auditor implements Observer,Console {
    private Account a;

    @Override
    public void update(EventType eventType, Account account) {
        if (eventType.equals(EventType.ADD)){
            this.a = account;
            display();
        }
    }

    @Override
    public void display() {
        String out = "";
        out += "Auditor:\n";
        out += "New account opened on " + a.getCreationDate() + " with number " +  a.getAccountNumber() + " and balance of "+ a.getAccountBalance() +"\n";
        System.out.println(out);
    }
}
