import java.io.*;
import java.util.*;

public class Main {
    static double[] A = new double[2], B = new double[2], C = new double[2], D = new double[2];

    static double distance(double t) {
        double x1 = A[0] + (B[0] - A[0]) * t;
        double y1 = A[1] + (B[1] - A[1]) * t;
        double x2 = C[0] + (D[0] - C[0]) * t;
        double y2 = C[1] + (D[1] - C[1]) * t;
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.hypot(dx, dy);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A[0] = Double.parseDouble(st.nextToken());
        A[1] = Double.parseDouble(st.nextToken());
        B[0] = Double.parseDouble(st.nextToken());
        B[1] = Double.parseDouble(st.nextToken());
        C[0] = Double.parseDouble(st.nextToken());
        C[1] = Double.parseDouble(st.nextToken());
        D[0] = Double.parseDouble(st.nextToken());
        D[1] = Double.parseDouble(st.nextToken());

        double left = 0.0, right = 1.0;
        for (int i = 0; i < 100; i++) {
            double m1 = (2 * left + right) / 3;
            double m2 = (left + 2 * right) / 3;
            double d1 = distance(m1);
            double d2 = distance(m2);
            if (d1 > d2) left = m1;
            else right = m2;
        }
        System.out.printf("%.10f\n", distance((left + right) / 2));
    }
}
