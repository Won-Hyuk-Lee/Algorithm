import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int H = sc.nextInt();
        int I = sc.nextInt();
        int A = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        
        int HI = H*I;
        int ARC = A*R*C;
        
        System.out.println(HI-ARC);
    }
}