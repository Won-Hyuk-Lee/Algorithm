import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] boardOne;
    static long[] boardTwo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boardOne = new long[n];
        boardTwo = new long[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            boardOne[i] = Long.parseLong(st1.nextToken());
            boardTwo[i] = Long.parseLong(st2.nextToken());
        }

        System.out.println(solve());
    }

    private static long solve() {
        long l = 0;
        long r = (long) 1e12;

        while (r - l >= 3) {
            long m1 = l + (r - l) / 3;
            long m2 = r - (r - l) / 3;
            long cost1 = cost(m1);
            long cost2 = cost(m2);

            if (cost1 < cost2) {
                r = m2;
            } else {
                l = m1;
            }
        }

        long min = Long.MAX_VALUE;
        for (long i = l; i <= r; i++) {
            min = Math.min(min, cost(i));
        }

        return min;
    }

    private static long cost(long base) {
        long total = 0;
        long h = base;

        for (int i = n / 2; i >= 0; i--) {
            total += Math.abs(boardOne[i] - h);
            total += Math.abs(boardTwo[i] - h);
            h++;
        }

        h = base + 1;
        for (int i = n / 2 + 1; i < n; i++) {
            total += Math.abs(boardOne[i] - h);
            total += Math.abs(boardTwo[i] - h);
            h++;
        }

        return total;
    }
}
