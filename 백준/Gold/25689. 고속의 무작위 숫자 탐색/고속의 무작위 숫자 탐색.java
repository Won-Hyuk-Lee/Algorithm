import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] MAP = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static List<int[]> vec = new ArrayList<>();
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, -1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] >= 1 && MAP[i][j] <= 6) {
                    vec.add(new int[]{i, j});
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Collections.sort(vec, (a, b) -> {
            for (int i = 0; i < 2; i++) {
                if (a[i] != b[i]) return a[i] - b[i];
            }
            return 0;
        });

        permute();

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void init() {
        for (int i = 0; i < 5; i++) Arrays.fill(visited[i], false);
    }

    static int bfs(int sy, int sx, int ey, int ex) {
        init();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sy, sx, 0});
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], d = cur[2];

            if (y == ey && x == ex) return d;

            for (int dir = 0; dir < 4; dir++) {
                int ny = y, nx = x;
                while (true) {
                    ny += moveY[dir];
                    nx += moveX[dir];
                    if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                        if (MAP[ny][nx] == 7) {
                            if (!visited[ny][nx]) {
                                visited[ny][nx] = true;
                                q.offer(new int[]{ny, nx, d + 1});
                            }
                            break;
                        } else if (MAP[ny][nx] == -1) {
                            ny -= moveY[dir];
                            nx -= moveX[dir];
                            if (!visited[ny][nx]) {
                                visited[ny][nx] = true;
                                q.offer(new int[]{ny, nx, d + 1});
                            }
                            break;
                        }
                    } else {
                        ny -= moveY[dir];
                        nx -= moveX[dir];
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            q.offer(new int[]{ny, nx, d + 1});
                        }
                        break;
                    }
                }
                ny = y + moveY[dir];
                nx = x + moveX[dir];
                if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && MAP[ny][nx] != -1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, d + 1});
                }
            }
        }
        return -1;
    }

    static void permute() {
        int n = vec.size();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        do {
            int total = 0;
            int sy = R, sx = C;
            boolean fail = false;
            for (int idx : p) {
                int[] dest = vec.get(idx);
                int d = bfs(sy, sx, dest[0], dest[1]);
                if (d == -1) {
                    fail = true;
                    break;
                }
                total += d;
                sy = dest[0];
                sx = dest[1];
            }
            if (!fail) answer = Math.min(answer, total);
        } while (nextPermutation(p));
    }

    static boolean nextPermutation(int[] p) {
        int i = p.length - 1;
        while (i > 0 && p[i - 1] >= p[i]) i--;
        if (i <= 0) return false;
        int j = p.length - 1;
        while (p[i - 1] >= p[j]) j--;
        int tmp = p[i - 1]; p[i - 1] = p[j]; p[j] = tmp;
        for (int a = i, b = p.length - 1; a < b; a++, b--) {
            tmp = p[a]; p[a] = p[b]; p[b] = tmp;
        }
        return true;
    }
}
