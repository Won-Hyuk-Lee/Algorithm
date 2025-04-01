import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] p = new char[n][];
        for (int i = 0; i < n; i++) {
            p[i] = br.readLine().toCharArray();
        }

        int[][] d = new int[n][m];
        d[n - 1][m - 1] = 1;
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                ans = (ans + d[i][j]) % MOD;
                if (i > 0 && (p[i - 1][j] == 'S' || p[i - 1][j] == 'B')) {
                    d[i - 1][j] = (d[i - 1][j] + d[i][j]) % MOD;
                }
                if (j > 0 && (p[i][j - 1] == 'E' || p[i][j - 1] == 'B')) {
                    d[i][j - 1] = (d[i][j - 1] + d[i][j]) % MOD;
                }
            }
        }

        System.out.println(ans);
    }
}
