import java.io.*;

public class Main {
    static final int MAX = 191230;
    static final int MOD = 1_000_000_007;
    static int[] d = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i < MAX; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(d[N]).append('\n');
        }

        System.out.print(sb);
    }
}
