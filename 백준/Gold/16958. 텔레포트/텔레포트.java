import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[][] dist;
    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        city = new int[N + 1][3];
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            city[i][0] = Integer.parseInt(st.nextToken());
            city[i][1] = Integer.parseInt(st.nextToken());
            city[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                int d = Math.abs(city[i][1] - city[j][1]) + Math.abs(city[i][2] - city[j][2]);
                if (city[i][0] == 1 && city[j][0] == 1) d = Math.min(d, T);
                dist[i][j] = d;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dist[a][b]).append('\n');
        }
        System.out.print(sb);
    }
}
