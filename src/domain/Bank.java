package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements Subject{
    private Map<Integer,Account> accounts;
    private List<Observer> observers;
    private String name;

    public Bank(String name){
        this.name = name;
        accounts = new HashMap<>();
        observers = new ArrayList<>();
    }

    public void addAccount(){
        Account account = new Account(accounts.size()+1,0);
        accounts.put(accounts.size()+1,account);
        updateObsrvers(account);
    }

    public void registerObserver(Observer o){
        if (o != null) {
            this.observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void updateObsrvers(Account account) {
        if (account == null){
            throw new IllegalArgumentException("wrong account");
        }
        for (Observer o:this.observers) {
            o.update(account);
        }
    }

    public Account getAccount(int accountNumber){
        return this.accounts.get(accountNumber);
    }

    public void withdraw(Account account, double amount){
       if (amount <= 0){
          throw new IllegalArgumentException("Not a legal number");
       }
       int id = account.getAccountNumber();
       accounts.get(id).setAccountBalance(accounts.get(id).getAccountBalance() - amount);
    }

    public void deposite(Account account, double amount){
       if (amount <= 0){
          throw new IllegalArgumentException("Not a legal number");
       }
       int id = account.getAccountNumber();
       accounts.get(id).setAccountBalance(accounts.get(id).getAccountBalance() + amount);
    }
}
