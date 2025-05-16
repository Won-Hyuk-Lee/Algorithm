import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x; this.y = y;
        }
    }

    static double ccw(Point a, Point b, Point c) {
        return (a.x * b.y + b.x * c.y + c.x * a.y)
             - (a.y * b.x + b.y * c.x + c.y * a.x);
    }

    static boolean inTriangle(Point a, Point b, Point c, Point p) {
        double abp = ccw(a, b, p);
        double bcp = ccw(b, c, p);
        double cap = ccw(c, a, p);
        return abp >= 0 && bcp >= 0 && cap >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] tri = new Point[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tri[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }
        if (ccw(tri[0], tri[1], tri[2]) < 0) {
            Point temp = tri[1];
            tri[1] = tri[2];
            tri[2] = temp;
        }
        double area = Math.abs(ccw(tri[0], tri[1], tri[2])) / 2.0;
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point p = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            if (inTriangle(tri[0], tri[1], tri[2], p)) count++;
        }
        System.out.printf("%.1f\n%d\n", area, count);
    }
}
