import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();
        long T = sc.nextLong();
        long S = sc.nextLong();

        long Zip = N + (N - 1) / 8 * S;
        long Dok = T + M + (M - 1) / 8 * (2 * T + S);

        if (Zip < Dok) {
            System.out.println("Zip");
            System.out.println(Zip);
        } else {
            System.out.println("Dok");
            System.out.println(Dok);
        }

        sc.close();
    }
}
