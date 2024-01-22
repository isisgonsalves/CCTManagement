/**
  The CreditCard class models a credit card. (Description from Assignment) 
  
  Isis Gonsalves
  816026980
*/

import java.time.LocalDate;

public class CreditCard
{
    private String cardNumber ;
    private LocalDate expiryDate;
    private double balance;
    private TransactionLog transactionLog;
    private final double limit; //added final
    
    public CreditCard(String cardNumber, LocalDate expiryDate){
        this.cardNumber=cardNumber;
        this.expiryDate = expiryDate; 
        this.limit = 5000.00; //constant
        
        //this commented line of code below was inserted for when a new cc is created,
        //the transaction ID would reset to 1, instead of continuing the counter.
        //However, a new connection between the Credit Card class and the TransactionIDCounter class was made.
        //Therefore, the UML diagram would be different than what was given.
        
        //TransactionIDCounter.newTransactionID = 1; 
        transactionLog = new TransactionLog();
    }
    
    public String getCardNumber(){
        return cardNumber;
    }
    
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public TransactionLog getTransactionLog(){
        return transactionLog;
    }
    
    public double getLimit(){
        return limit;
    }
    
    public boolean isExpired(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate = getExpiryDate();
        
        //isAfter method to compare dates was found on geekforgeeks website.
        if(currentDate.isAfter(expiryDate))
            return true;
        else
            return false;
    }
    
    public boolean isOverLimit(){
        
        if( getLimit() < getBalance())
            return true;
        else
            return false;
    }
    
    public boolean charge(double amount){
        //add transaction
        //add amount to balance
    
        double bal = getBalance();
        double limit = getLimit();
        
        bal=bal+amount;
        
        if( bal < limit ){

            transactionLog.add(amount);
            this.balance = this.balance + amount;
            
            return true;
            
        }
        else{
            System.out.println("Sorry, the charge $" + amount + " will bring balance over the limit...\n");
            return false;
        }
            
    }
    
    public boolean cancel(int transactionID){
        
        //remove/cancel transaction
        //decrease amount from balance
        
        double amount = transactionLog.cancel(transactionID);
            
        this.balance= this.balance - amount;
        
        return true;
    }
    
    public String getStatement(){
        return ("Credit Card: " + getCardNumber() + 
                " Expiry Date: " + getExpiryDate() +
                " Balance: $" + String.format("%.2f",getBalance()) + 
                " Over Limit: " + isOverLimit () +
                " \nTRANSACTIONS: \n" + transactionLog.toString() + "\n");
    }
    
    //this method was guided by Lab 3 Mr.Daniel explanation...
    public boolean equals(Object obj){
        
        if (obj instanceof CreditCard) {
          CreditCard c = (CreditCard) obj;
          String anotherCardNumber = c.getCardNumber();
          boolean result = this.cardNumber.equals(anotherCardNumber);
          
          return result;
        }
        
        return false;
    }
    
    public static boolean isValid(CreditCard cc){
        
        String cardNum = cc.getCardNumber();
        
        //checking if number is 16 chars long and isn't expired
        
        if ((cardNum.length() == 16) && !cc.isExpired()){
            return true;
        }
        return false;
    }
    
}
