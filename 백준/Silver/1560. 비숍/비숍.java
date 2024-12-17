import java.math.BigInteger;
import java.util.Scanner;
 
public class Main {
         
    public static void main(String[] args)
    {
                BigInteger c = new BigInteger("0");
         
                Scanner sc = new Scanner(System.in);
                
                c = sc.nextBigInteger();
                
                if(c.compareTo(BigInteger.ONE) == 0)
                    System.out.println(1);
                
                else if(c.compareTo(BigInteger.valueOf(2)) == 0)
                    System.out.println(2);
                
                else
                     System.out.println(c.add(c.subtract(BigInteger.valueOf(2))));
    }
    
}