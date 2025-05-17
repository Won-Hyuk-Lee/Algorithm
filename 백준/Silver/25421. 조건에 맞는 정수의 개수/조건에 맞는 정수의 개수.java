import java.io.*;

public class Main {
    static final int MOD = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (Math.abs(j - k) <= 2) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }

        System.out.println(sum);
    }
}
