import java.io.*;
import java.util.*;

class Main {
    static int M, N, H;
    static int[][][] box, dist;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        dist = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                    if (box[h][i][j] == 1) q.add(new int[]{h, i, j});
                    if (box[h][i][j] == 0) dist[h][i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 6; d++) {
                int nh = now[0] + dz[d];
                int nx = now[1] + dx[d];
                int ny = now[2] + dy[d];
                if (nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M) continue;
                if (dist[nh][nx][ny] == -1) {
                    dist[nh][nx][ny] = dist[now[0]][now[1]][now[2]] + 1;
                    q.add(new int[]{nh, nx, ny});
                }
            }
        }

        int result = 0;
        for (int[][] floor : dist) {
            for (int[] row : floor) {
                for (int d : row) {
                    if (d == -1) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, d);
                }
            }
        }
        System.out.println(result);
    }
}