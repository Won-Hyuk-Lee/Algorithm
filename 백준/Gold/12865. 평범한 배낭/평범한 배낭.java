import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int[] W; // 무게
    static int[] V; // 가치

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 물건의 갯수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        W = new int[N];
        V = new int[N];

        dp = new int[N + 1][K + 1]; // DP초기화

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (W[i - 1] <= w) {
                    // 현재 물건을 넣지 않는 경우와 넣는 경우 중 큰 값 선택
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i - 1]] + V[i - 1]);
                } else {
                    // 현재 물건을 넣지 못하는 경우
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
