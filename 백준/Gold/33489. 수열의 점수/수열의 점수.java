import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> fib = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        fib.add(1L);
        fib.add(1L);
        while (fib.get(fib.size() - 1) <= 600_000) {
            int n = fib.size();
            fib.add(fib.get(n - 1) + fib.get(n - 2));
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            long X = Long.parseLong(input[0]);
            long Y = Long.parseLong(input[1]);

            long bestX = 1, bestY = 1;
            int maxScore = 2;

            for (int i = 2; i < fib.size(); i++) {
                long fx = fib.get(i);
                long fy = fib.get(i - 1);

                long k = Math.min(X / fx, Y / fy);
                if (k == 0) continue;

                long tx = fx * k;
                long ty = fy * k;

                int score = i + 1;
                if (score > maxScore) {
                    maxScore = score;
                    bestX = tx;
                    bestY = ty;
                }
            }
            sb.append(bestX).append(" ").append(bestY).append("\n");
        }
        System.out.print(sb);
    }
}
