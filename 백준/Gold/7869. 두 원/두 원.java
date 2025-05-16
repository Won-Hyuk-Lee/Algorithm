import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble(), y1 = sc.nextDouble(), r1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble(), r2 = sc.nextDouble();
        double d = Math.hypot(x1 - x2, y1 - y2);

        if (r1 + r2 <= d) {
            System.out.println("0.000");
            return;
        }

        if (Math.abs(r1 - r2) >= d) {
            double r = Math.min(r1, r2);
            System.out.printf("%.3f\n", Math.PI * r * r);
            return;
        }

        double a1 = 2 * Math.acos((r1 * r1 + d * d - r2 * r2) / (2 * r1 * d));
        double a2 = 2 * Math.acos((r2 * r2 + d * d - r1 * r1) / (2 * r2 * d));

        double s1 = 0.5 * r1 * r1 * (a1 - Math.sin(a1));
        double s2 = 0.5 * r2 * r2 * (a2 - Math.sin(a2));

        System.out.printf("%.3f\n", s1 + s2);
    }
}
