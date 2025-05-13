import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double dist = Math.hypot(X, Y);

        if (D <= T) {
            System.out.println(dist);
        } else {
            int N = (int) (dist / D);
            if (dist == N * D) {
                System.out.println(N * T);
            } else if (N == 0) {
                double a = T + T;
                double b = dist;
                double c = T + (D - dist);
                System.out.println(Math.min(a, Math.min(b, c)));
            } else {
                double remain = dist - N * D;
                double a = T;
                double b = remain;
                System.out.println(Math.min(a, b) + N * T);
            }
        }
    }
}
