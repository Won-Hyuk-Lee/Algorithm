import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        for (int i = 0; i < testCase; i++) {
            int m = sc.nextInt();
            String thisType = sc.next();
            
            for (int j = 0; j < m; j++) {
                if (thisType.equals("C")) {
                    char c = sc.next().charAt(0);
                    System.out.print( (c - '@' + " ") );
                }
                else if (thisType.equals("N")) {
                    int n = sc.nextInt();
                    System.out.print( ( (char)(n + 64) + " " ) );
                }
            }
            System.out.println();
        }
 
    }
}