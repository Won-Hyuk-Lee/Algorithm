import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String s = sc.next();
        
        long hash = 0;
        long pow = 1;
        int mod = 1234567891;
        
        for (int i = 0; i < n; i++) {
            int value = s.charAt(i) - 'a' + 1;
            hash = (hash + value * pow) % mod;
            pow = (pow * 31) % mod;
        }
        System.out.println(hash);
        
        sc.close();
    }
}
