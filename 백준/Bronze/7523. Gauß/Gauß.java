import java.util.Scanner;

public class Main {

    public static long sum(long num) {
        return num * (num + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            long sum = sum(b);

            if (a < 0) {
                sum -= sum(Math.abs(a));
            } else if (a > 1) {
                sum -= sum(a - 1);
            }

            System.out.println("Scenario #" + i + ":");
            System.out.println(sum);
            System.out.println();
        }

        sc.close();
    }
}
