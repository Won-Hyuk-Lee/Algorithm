import java.util.*;
import java.io.*;

public class Main {
    private final static int MAX = 30;
    static int[][] dp = new int[MAX + 1][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        createCombie();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            bw.write(dp[n][r] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void createCombie(){ 
        for (int i = 1; i <= MAX; i++) {
            dp[i][1] = i;
        }

        for (int j = 2; j <= MAX; j++) {
            for (int k = 2; k <= MAX; k++) {
                dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
            }
        }
    }
}