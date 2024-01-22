/**
 The Transaction class models a monetary transaction. (Description from Assignment)
 
 Isis Gonsalves
 816026980
 
 */

import java.time.LocalDate; 
import java.util.Date;

public class Transaction
{
    private LocalDate transactionDate; //changed all to private
    private double amount;
    private int transactionID;
    private boolean cancelled;
    
    //constructor
    public Transaction(double amount){
        
        //LocalDate.now() to access current date was found on tutorialspoint.com
        LocalDate currentDate = LocalDate.now();
        transactionDate = currentDate;
        this.amount=amount;
        transactionID= TransactionIDCounter.getNewTransactionID(); 
        cancelled= false;
    }
    
    //overloaded constructor
    public Transaction(double amount, LocalDate transactionDate){
        this.transactionDate = transactionDate;
        this.amount=amount;
        transactionID= TransactionIDCounter.getNewTransactionID();
        cancelled= false;
    }
    
    //mutator
    public void setCancelled(boolean cancelled){
        if(cancelled == true){
            this.cancelled = true;
        }
        else
            this.cancelled = false;
    }
    
    //accessors
    public LocalDate getTransactionDate(){
        return transactionDate;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public int getTransactionID(){
        return transactionID;
    }
    
    public boolean getCancelled(){
        return cancelled;
    }
    
    public String toString(){
        return ("Date: " + getTransactionDate() +
                " Amount: $" + String.format("%.2f",getAmount()) + 
                " Transaction ID: " + getTransactionID() + 
                " Cancelled: " + getCancelled() );
    }
    
    //this method was guided by Lab 3 Mr.Daniel explanation...
    public boolean equals(Object obj) {

        if (obj instanceof Transaction) {
          Transaction t = (Transaction) obj;
          int anotherTransactionID = t.getTransactionID();
          boolean result = this.transactionID == anotherTransactionID;
          
          return result;
    
        }
        
    return false;

  }
  
}
