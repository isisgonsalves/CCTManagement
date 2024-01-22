/**
  The CCTManagementSystem class runs a simulation of credit charges and cancellations.
  
  Isis Gonsalves
  816026980
*/
import java.time.LocalDate;

public class CCTManagementSystem
{
    public static void main(String[] args){
        
        LocalDate date = LocalDate.of(2024,6,24);
        
        String number = "7623986538265385";
        CreditCard cc = new CreditCard (number, date);
        System.out.println("New Credit Card: \n");
        
        if(CreditCard.isValid(cc)){
            
            System.out.println(cc.getStatement());
            cc.charge(1000);
            
            System.out.println(cc.getStatement());
            cc.charge(7000.89);
            
            System.out.println(cc.getStatement());
            cc.charge(125.79);
            
            System.out.println(cc.getStatement());
            cc.cancel(2);
            
            System.out.println(cc.getStatement());
            cc.charge(800.00);
            
            System.out.println(cc.getStatement()); 
        }
        
    }
}
