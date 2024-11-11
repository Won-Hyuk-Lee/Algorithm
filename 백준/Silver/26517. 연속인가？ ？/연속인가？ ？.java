import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long t = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();

        long result = a * t + b;
        
        System.out.println(result == c * t + d ? "Yes " + result : "No");
    }
}
