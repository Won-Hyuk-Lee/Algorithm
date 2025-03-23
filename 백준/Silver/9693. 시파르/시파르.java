import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = 1;

        while (N != 0) {
            int ans = 0;
            for (int i = 5; i <= N; i *= 5) {
                ans += N / i;
            }
            System.out.println("Case #" + T++ + ": " + ans);
            N = sc.nextInt();
        }
    }
}
