import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point A = new Point(sc.nextInt(), sc.nextInt());
        Point B = new Point(sc.nextInt(), sc.nextInt());
        Point C = new Point(sc.nextInt(), sc.nextInt());
        Point D = new Point(sc.nextInt(), sc.nextInt());

        System.out.println(ccw(A, B, C) * ccw(A, B, D) < 0 &&
                           ccw(C, D, A) * ccw(C, D, B) < 0 ? 1 : 0);
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long cross = (long)(p2.x - p1.x) * (p3.y - p1.y) -
                     (long)(p2.y - p1.y) * (p3.x - p1.x);
        return Long.compare(cross, 0);
    }
}
