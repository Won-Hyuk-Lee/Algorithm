import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); //스티커 열
            int[][] stickers = new int[2][n + 1]; //스티커점수배열
            int[][] dp = new int[2][n + 1]; //DP배열

            //스티커 점수
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //초기값
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            //DP계산
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j];
            }

            //최대값 계산
            int result = Math.max(dp[0][n], dp[1][n]);
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}