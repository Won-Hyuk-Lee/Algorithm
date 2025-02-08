import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long before = sc.nextLong();
        long cnt = 1, sum = 0;

        for (long i = 2; i <= N; i++) {
            long now = sc.nextLong();
            if (before < now) {
                cnt++;
            } else {
                sum += cnt * (cnt + 1) / 2;
                cnt = 1;
            }
            before = now;
        }
        sum += cnt * (cnt + 1) / 2;

        System.out.println(sum);
        sc.close();
    }
}
