import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] d = new int[n][2];
            int[][] pas = new int[n - 1][2];
            int[][] dbb = new int[n - 1][2];

            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) pas[i][0] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) dbb[i][0] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) pas[i][1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) dbb[i][1] = Integer.parseInt(st.nextToken());

            d[0][0] = l1;
            d[0][1] = l2;

            for (int i = 1; i < n; i++) {
                d[i][0] = Math.min(d[i - 1][0] + dbb[i - 1][0], d[i - 1][1] + pas[i - 1][1]);
                d[i][1] = Math.min(d[i - 1][1] + dbb[i - 1][1], d[i - 1][0] + pas[i - 1][0]);
            }

            System.out.println(Math.min(d[n - 1][0] + s1, d[n - 1][1] + s2));
        }
    }
}
