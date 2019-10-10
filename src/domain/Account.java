package domain;

import java.time.LocalDate;

public class Account {

   private int accountNumber;
   private double accountBalance;
   private LocalDate creationDate;

   public Account(int accountNumber, double accountBalance){
      this.creationDate = LocalDate.now();
      this.accountNumber = accountNumber;
      this.accountBalance = accountBalance;
   }

   public Account(int accountNumber){
      this(accountNumber, 0);
   }

   public void setAccountBalance(double newBalance){
      this.accountBalance = newBalance;
   }

   public double getAccountBalance() {
      return accountBalance;
   }

   public int getAccountNumber() {
      return accountNumber;
   }

   @Override
   public String toString(){
      return "Creation date: " + this.creationDate.toString() +"\nAccount Number: " + this.accountNumber + "\nAccount Balance: " + this.accountBalance + "\n";
   }

   public LocalDate getCreationDate() {
      return creationDate;
   }
}
