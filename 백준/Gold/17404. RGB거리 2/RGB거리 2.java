import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }

        int res = INF;
        for (int start = 0; start < 3; start++) {
            int[][] dp = new int[n][3];
            for (int j = 0; j < 3; j++) dp[0][j] = (j == start) ? cost[0][j] : INF;

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j != start) res = Math.min(res, dp[n - 1][j]);
            }
        }

        System.out.println(res);
    }
}
