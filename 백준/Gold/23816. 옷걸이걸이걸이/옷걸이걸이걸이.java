import java.util.*;

public class Main {
    static int[][] dp;
    static int[] hanger = {3, 7, 15};
    static int[] dress = {2, 4, 0};

    static int DP(int n, int m) {
        if (m < 0) {
            return -1;
        } else if (m == 0) {
            return 0;
        }
        if (n == 0) {
            return (m == 0) ? 0 : -1;
        }
        if (n >= m) {
            return m;
        }
        if (dp[n][m] != -2) {
            return dp[n][m];
        }
        dp[n][m] = -1;
        for (int i = 0; i < 3; i++) {
            if (m < hanger[i]) continue;
            int tmp = DP(n - 1, m - hanger[i]);
            if (tmp == -1) continue;
            dp[n][m] = Math.max(dp[n][m], tmp + dress[i]);
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        dp = new int[N + 1][M + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -2);
        }

        System.out.println(DP(N, M));
    }
}
