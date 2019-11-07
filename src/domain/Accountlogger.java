package domain;

import java.util.ArrayList;

public class Accountlogger implements Observer, Console {
    private ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public void display() {
        System.out.println("Total accounts : " + accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i+1 + ". " + "Account number : " + accounts.get(i).getAccountNumber() + "\t" + "Saldo : " + accounts.get(i).getAccountBalance());
        }
    }

    @Override
    public void update(EventType eventType, Account account) {
        System.out.println(String.format("Change: %s\tRekening: %s", eventType.name(), account.getAccountNumber()));

        if (eventType.equals(EventType.ADD)){
            for (Account value : accounts){
                if (account.getAccountNumber() == value.getAccountNumber()){
                    throw new IllegalArgumentException("Account already exists");
                }
            }
            accounts.add(account);
        }

        if (eventType.equals(EventType.CLOSE)){
            accounts.remove(account);
        }

    }
}
