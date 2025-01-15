import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();

        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = scanner.nextInt();
        }

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            int c = (d[i] + d[i + 1]) * X;
            minimum = Math.min(c, minimum);
        }

        System.out.println(minimum);

        scanner.close();
    }
}
