import java.util.*;

public class Main {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x; this.y = y;
        }
        double dist(Point p) {
            return Math.hypot(x - p.x, y - p.y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point start = new Point(sc.nextDouble(), sc.nextDouble());
        Point end = new Point(sc.nextDouble(), sc.nextDouble());
        int N = sc.nextInt();
        Point[] cannons = new Point[N];
        for (int i = 0; i < N; i++)
            cannons[i] = new Point(sc.nextDouble(), sc.nextDouble());

        int total = N + 2;
        double[][] dist = new double[total][total];
        Point[] points = new Point[total];
        points[0] = start;
        points[1] = end;
        for (int i = 0; i < N; i++) points[i + 2] = cannons[i];

        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (i == j) continue;
                double d = points[i].dist(points[j]);
                if (i >= 2)
                    dist[i][j] = Math.min(d / 5, 2 + Math.abs(d - 50) / 5);
                else
                    dist[i][j] = d / 5;
            }
        }

        double[] time = new double[total];
        Arrays.fill(time, Double.MAX_VALUE);
        time[0] = 0;
        boolean[] visited = new boolean[total];
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));
        pq.offer(new double[]{0, 0});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int now = (int) cur[0];
            if (visited[now]) continue;
            visited[now] = true;
            for (int i = 0; i < total; i++) {
                if (time[i] > time[now] + dist[now][i]) {
                    time[i] = time[now] + dist[now][i];
                    pq.offer(new double[]{i, time[i]});
                }
            }
        }

        System.out.printf("%.6f%n", time[1]);
    }
}
