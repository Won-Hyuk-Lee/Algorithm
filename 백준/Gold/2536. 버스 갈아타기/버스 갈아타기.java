import java.util.*;

public class Main {
    static class Bus {
        int num, x1, y1, x2, y2;
        Bus(int num, int x1, int y1, int x2, int y2) {
            this.num = num;
            this.x1 = Math.min(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.x2 = Math.max(x1, x2);
            this.y2 = Math.max(y1, y2);
        }

        boolean inRange(int x, int y) {
            return x1 <= x && x <= x2 && y1 <= y && y <= y2;
        }

        boolean intersects(Bus b) {
            return !(x2 < b.x1 || b.x2 < x1 || y2 < b.y1 || b.y2 < y1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt(), K = sc.nextInt();
        Bus[] buses = new Bus[K + 1];
        for (int i = 1; i <= K; i++)
            buses[i] = new Bus(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

        int sx = sc.nextInt(), sy = sc.nextInt();
        int ex = sc.nextInt(), ey = sc.nextInt();

        boolean[] visited = new boolean[K + 1];
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            if (buses[i].inRange(sx, sy)) {
                q.add(i);
                visited[i] = true;
                dist[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= K; i++) {
                if (!visited[i] && buses[cur].intersects(buses[i])) {
                    visited[i] = true;
                    dist[i] = dist[cur] + 1;
                    q.add(i);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            if (buses[i].inRange(ex, ey))
                answer = Math.min(answer, dist[i]);
        }

        System.out.println(answer);
    }
}
