import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static int[][] map, copy;
    static List<int[]> virus = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }
        buildWall(0);
        System.out.println(max);
    }

    static void buildWall(int count) {
        if (count == 3) {
            spread();
            return;
        }
        for (int i = 0; i < N * M; i++) {
            int x = i / M, y = i % M;
            if (map[x][y] == 0) {
                map[x][y] = 1;
                buildWall(count + 1);
                map[x][y] = 0;
            }
        }
    }

    static void spread() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) copy[i] = map[i].clone();
        Queue<int[]> q = new LinkedList<>(virus);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        int safe = 0;
        for (int[] row : copy)
            for (int v : row) if (v == 0) safe++;
        max = Math.max(max, safe);
    }
}
