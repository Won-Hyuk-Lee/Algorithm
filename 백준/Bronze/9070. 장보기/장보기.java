import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int bestPrice = Integer.MAX_VALUE;
            double bestRatio = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int W = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                
                double ratio = (double) W / C;
                
                if (ratio > bestRatio || (ratio == bestRatio && C < bestPrice)) {
                    bestRatio = ratio;
                    bestPrice = C;
                }
            }

            System.out.println(bestPrice);
        }
    }
}