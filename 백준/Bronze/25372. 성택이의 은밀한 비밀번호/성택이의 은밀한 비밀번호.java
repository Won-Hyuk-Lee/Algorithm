import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            String password = scanner.next();
            System.out.println(password.length() >= 6 && password.length() <= 9 ? "yes" : "no");
        }
        scanner.close();
    }
}