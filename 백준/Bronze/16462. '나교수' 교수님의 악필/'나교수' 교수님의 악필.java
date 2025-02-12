import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalScore = 0;
        
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int sum = 0;
            
            for (char c : s.toCharArray()) {
                int digit = (c == '0' || c == '6') ? 9 : c - '0';
                sum = sum * 10 + digit;
            }
            
            totalScore += Math.min(sum, 100);
        }
        
        System.out.println((int) Math.round(totalScore / n));
        sc.close();
    }
}