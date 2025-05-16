import java.util.*;

public class Main {
    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x; this.y = y;
        }
    }

    static long ccw(Point a, Point b, Point c) {
        return a.x * b.y + b.x * c.y + c.x * a.y
             - a.y * b.x - b.y * c.x - c.y * a.x;
    }

    static boolean intersect(Point a, Point b, Point c, Point d) {
        long ab1 = ccw(a, b, c);
        long ab2 = ccw(a, b, d);
        long cd1 = ccw(c, d, a);
        long cd2 = ccw(c, d, b);

        if (ab1 == 0 && ab2 == 0 && cd1 == 0 && cd2 == 0) {
            return Math.max(a.x, b.x) >= Math.min(c.x, d.x) &&
                   Math.max(c.x, d.x) >= Math.min(a.x, b.x) &&
                   Math.max(a.y, b.y) >= Math.min(c.y, d.y) &&
                   Math.max(c.y, d.y) >= Math.min(a.y, b.y);
        }
        return ab1 * ab2 <= 0 && cd1 * cd2 <= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Point p1 = new Point(sc.nextLong(), sc.nextLong());
            Point p2 = new Point(sc.nextLong(), sc.nextLong());

            long x1 = sc.nextLong(), y1 = sc.nextLong();
            long x2 = sc.nextLong(), y2 = sc.nextLong();

            long minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
            long minY = Math.min(y1, y2), maxY = Math.max(y1, y2);

            Point r1 = new Point(minX, minY);
            Point r2 = new Point(minX, maxY);
            Point r3 = new Point(maxX, maxY);
            Point r4 = new Point(maxX, minY);

            boolean cross = intersect(p1, p2, r1, r2)
                         || intersect(p1, p2, r2, r3)
                         || intersect(p1, p2, r3, r4)
                         || intersect(p1, p2, r4, r1);

            if (!cross) {
                if (minX < p1.x && p1.x < maxX && minX < p2.x && p2.x < maxX &&
                    minY < p1.y && p1.y < maxY && minY < p2.y && p2.y < maxY)
                    cross = true;
            }

            System.out.println(cross ? "T" : "F");
        }
    }
}
