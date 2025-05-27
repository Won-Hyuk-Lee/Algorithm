import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> prettyNumbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int sum = digitSum(i);
            if (i % sum == 0) {
                prettyNumbers.add(i);
            }
        }

        int[] dp = new int[N + 1];
        for (int p : prettyNumbers) {
            dp[p]++;
            for (int j = p + 1; j <= N; j++) {
                dp[j] += dp[j - p];
                if (dp[j] >= K) dp[j] -= K;
            }
        }

        System.out.println(dp[N] % K);
    }

    private static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
