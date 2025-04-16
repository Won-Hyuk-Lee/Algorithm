import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            ans += (s.charAt(i) - 64) * Math.pow(26, (s.length() - i - 1));
        }
        
        System.out.println(ans);
        scanner.close();
    }
}