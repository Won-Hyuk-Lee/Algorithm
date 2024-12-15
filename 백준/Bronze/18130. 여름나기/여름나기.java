import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long Q = sc.nextLong();

        long id = 0;
        long ans = Long.MAX_VALUE;

        for (int n = 1; n <= N; n++) {
            long P = sc.nextLong();
            long K = sc.nextLong();
            long C = sc.nextLong();

            long cnt = (Q - 1) / K;
            long val = P + cnt * (cnt + 1) / 2 * C;

            if (val < ans) {
                id = n;
                ans = val;
            }
        }

        System.out.println(id + " " + ans);
    }
}