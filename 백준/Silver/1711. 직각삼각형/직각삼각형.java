import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static long dist2(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] p = new Point[n];
        for (int i = 0; i < n; i++)
            p[i] = new Point(sc.nextInt(), sc.nextInt());

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    long a = dist2(p[i], p[j]);
                    long b = dist2(p[j], p[k]);
                    long c = dist2(p[k], p[i]);
                    if (a + b == c || a + c == b || b + c == a)
                        count++;
                }

        System.out.println(count);
    }
}
