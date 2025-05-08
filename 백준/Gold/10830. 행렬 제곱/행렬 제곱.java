import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000;
    static int N;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, B);
        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int v : row) sb.append(v).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static int[][] pow(int[][] A, long exp) {
        if (exp == 1) return A;

        int[][] half = pow(A, exp / 2);
        int[][] res = multiply(half, half);
        if (exp % 2 == 1) res = multiply(res, origin);
        return res;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j];
                }
                res[i][j] = sum % MOD;
            }
        }
        return res;
    }
}
