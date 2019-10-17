package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements Subject{
    private Map<Integer,Account> accounts;
    private Map<EventType,List<Observer>> observers;
    private String name;

    public Bank(String name){
        this.name = name;
        accounts = new HashMap<>();
        observers = new HashMap<>();
    }

    public void addAccount(){
        addAccount(0);
    }

    public void addAccount(double balance){
       Account account = new Account(accounts.size()+1,balance);
       accounts.put(accounts.size()+1,account);
       updateObsrvers(EventType.ADD,account);
    }

    @Override
    public void registerObserver(List<EventType> eventTypes, Observer o){
        for (EventType e:eventTypes) {
            //e.addObserver(o);
            addObserver(e,o);
        }
    }
     @Override
    public void addObserver(EventType e, Observer o){
        observers.get(e).add(o);
    }

    @Override
    public void removeObserver(EventType e ,Observer o) {
        this.observers.get(e).remove(o);
    }

    @Override
    public void updateObsrvers(EventType e, Account account) {
        if (account == null){
            throw new IllegalArgumentException("wrong account");
        }
        for (Observer o:this.observers.get(e)) {
            o.update(account);
        }
    }

    public Account getAccount(int accountNumber){
        return this.accounts.get(accountNumber);
    }

   public Map<Integer, Account> getAccounts() {
      return accounts;
   }

   public void withdraw(Account account, double amount){
       if (amount <= 0){
          throw new IllegalArgumentException("Not a legal number");
       }
       int id = account.getAccountNumber();
       accounts.get(id).setAccountBalance(accounts.get(id).getAccountBalance() - amount);
       updateObsrvers(EventType.WITHDRAW,account);
    }

    public void deposit(Account account, double amount){
       if (amount <= 0){
          throw new IllegalArgumentException("Not a legal number");
       }
       int id = account.getAccountNumber();
       accounts.get(id).setAccountBalance(accounts.get(id).getAccountBalance() + amount);
       updateObsrvers(EventType.DEPOSIT,account);
    }
}
