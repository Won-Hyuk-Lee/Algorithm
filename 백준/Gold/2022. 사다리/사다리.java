import java.io.*;
import java.util.*;

public class Main {
    static double a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        double low = 0, high = Math.min(a, b), mid = 0;
        for (int i = 0; i < 100; i++) {
            mid = (low + high) / 2;
            double h1 = Math.sqrt(a * a - mid * mid);
            double h2 = Math.sqrt(b * b - mid * mid);
            double h = (h1 * h2) / (h1 + h2);
            if (h < c) high = mid;
            else low = mid;
        }

        System.out.printf("%.3f\n", mid);
    }
}
