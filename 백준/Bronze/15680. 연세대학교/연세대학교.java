import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        if(num == 0) System.out.println("YONSEI");
            else System.out.println("Leading the Way to the Future");
        sc.close();
    }
}