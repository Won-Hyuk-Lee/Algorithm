import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] taste = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int d = 0; d < N; d++) taste[i][d] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[M];
        for (int i = 0; i < M; i++) dp[i] = taste[i][0];

        for (int day = 1; day < N; day++) {
            int max1 = -1, max2 = -1, idx1 = -1;
            for (int i = 0; i < M; i++) {
                if (dp[i] > max1) {
                    max2 = max1;
                    max1 = dp[i];
                    idx1 = i;
                } else if (dp[i] > max2) {
                    max2 = dp[i];
                }
            }
            int[] next = new int[M];
            for (int i = 0; i < M; i++) {
                int diff = ((i == idx1) ? max2 : max1) + taste[i][day];
                int same = dp[i] + taste[i][day] / 2;
                next[i] = Math.max(diff, same);
            }
            dp = next;
        }

        int ans = 0;
        for (int v : dp) ans = Math.max(ans, v);
        System.out.println(ans);
    }
}
