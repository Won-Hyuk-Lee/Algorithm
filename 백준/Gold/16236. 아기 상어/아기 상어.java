import java.util.*;

public class Main {
    static int N, time, size = 2, eat;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static Shark shark;

    static class Shark {
        int x, y;
        Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        public int compareTo(Fish f) {
            if (this.dist == f.dist) {
                if (this.x == f.x) return this.y - f.y;
                return this.x - f.x;
            }
            return this.dist - f.dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }

        while (true) {
            Fish fish = bfs();
            if (fish == null) break;
            shark.x = fish.x;
            shark.y = fish.y;
            time += fish.dist;
            map[fish.x][fish.y] = 0;
            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }
        }
        System.out.println(time);
    }

    static Fish bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;
        List<Fish> fishes = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d], dist = cur[2] + 1;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > size) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist});
                if (map[nx][ny] > 0 && map[nx][ny] < size)
                    fishes.add(new Fish(nx, ny, dist));
            }
        }

        if (fishes.isEmpty()) return null;
        Collections.sort(fishes);
        return fishes.get(0);
    }
}
