import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Point[] points = new Point[N];
            Set<Point> pointSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
                pointSet.add(points[i]);
            }

            int maxArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int dx = points[j].x - points[i].x;
                    int dy = points[j].y - points[i].y;
                    int area = dx * dx + dy * dy;
                    if (area <= maxArea) continue;

                    Point p3 = new Point(points[j].x - dy, points[j].y + dx);
                    Point p4 = new Point(points[i].x - dy, points[i].y + dx);
                    if (pointSet.contains(p3) && pointSet.contains(p4)) {
                        maxArea = area;
                    }

                    p3 = new Point(points[j].x + dy, points[j].y - dx);
                    p4 = new Point(points[i].x + dy, points[i].y - dx);
                    if (pointSet.contains(p3) && pointSet.contains(p4)) {
                        maxArea = area;
                    }
                }
            }
            sb.append(maxArea).append('\n');
        }
        System.out.print(sb);
    }
}
