import java.util.*;

public class Main {
    static class Segment {
        long x1, y1, x2, y2, weight;
        Segment(long x1, long y1, long x2, long y2, long weight) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.weight = weight;
        }
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long cross = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        return Long.compare(cross, 0);
    }

    static boolean intersect(Segment a, Segment b) {
        int ab1 = ccw(a.x1, a.y1, a.x2, a.y2, b.x1, b.y1);
        int ab2 = ccw(a.x1, a.y1, a.x2, a.y2, b.x2, b.y2);
        int cd1 = ccw(b.x1, b.y1, b.x2, b.y2, a.x1, a.y1);
        int cd2 = ccw(b.x1, b.y1, b.x2, b.y2, a.x2, a.y2);

        if (ab1 * ab2 == 0 && cd1 * cd2 == 0) {
            long aMinX = Math.min(a.x1, a.x2), aMaxX = Math.max(a.x1, a.x2);
            long aMinY = Math.min(a.y1, a.y2), aMaxY = Math.max(a.y1, a.y2);
            long bMinX = Math.min(b.x1, b.x2), bMaxX = Math.max(b.x1, b.x2);
            long bMinY = Math.min(b.y1, b.y2), bMaxY = Math.max(b.y1, b.y2);
            return aMinX <= bMaxX && bMinX <= aMaxX && aMinY <= bMaxY && bMinY <= aMaxY;
        }
        return ab1 * ab2 <= 0 && cd1 * cd2 <= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Segment[] seg = new Segment[n];

        for (int i = 0; i < n; i++) {
            long sx = sc.nextLong();
            long sy = sc.nextLong();
            long ex = sc.nextLong();
            long ey = sc.nextLong();
            long w = sc.nextLong();
            seg[i] = new Segment(sx, sy, ex, ey, w);
        }

        Arrays.sort(seg, Comparator.comparingLong(o -> o.weight));
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                if (intersect(seg[i], seg[j])) cnt++;
            }
            answer += (cnt + 1) * seg[i].weight;
        }

        System.out.println(answer);
    }
}
