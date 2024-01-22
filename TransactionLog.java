/**
 The TransactionLog class manages one or more transaction objects within a transactions collection.
 (Description from Assignment)
 
 Isis Gonsalves
 816026980
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class TransactionLog{
    
    //added private
    private ArrayList<Transaction> transactions;
    
    public TransactionLog(){        
        transactions = new ArrayList <Transaction> (); 
    }
    
    //added
    public Transaction getTransactions(int i){
        if(i>=0 && i<transactions.size())
            return transactions.get(i);
        return null;
    }
    
    public boolean add(double amount){
        
        Transaction trans = new Transaction(amount); //creating new transaction
        transactions.add(trans); //adding to the arrayList
        
        return true;
    }
    
    //found that the iterator method can traverse an ArrayList
    //Description of it was found on 
    //docs.oracle.com/javase/8/docs/api/java/util/ArrayList
    
    public double cancel(int transactionID){
        double amt=0.0;
        
        
        Iterator <Transaction> iteration = transactions.iterator();
        
        while( iteration.hasNext()){
            Transaction transactions = iteration.next(); //getting the next trans
            int ID = transactions.getTransactionID(); //pulling the ID
            
                if(ID == transactionID){ 
                    transactions.setCancelled(true);
                    amt = transactions.getAmount(); //pulling amount cancelled
                }
                
                
            }
            return amt;
    }
    
    public String toString(){
        
        String space = ""; //used this variable to continuously append the
                           //to strings of each item in Array List
                           //Without this, it only returned one item instead of all.
                
        Iterator <Transaction> iteration = transactions.iterator();
        
        while( iteration.hasNext()){
            Transaction transactions = iteration.next();
            space = space + transactions.toString() + "\n";
        }
        return space;
        
    }
}
