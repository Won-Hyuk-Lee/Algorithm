import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long now = 0;
        long solve = 0;
        long now2 = 0;
        long now3 = 0;

        Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);

            if (a == 0) {
                now2++;
                continue;
            }
            if (b == 0) {
                now3++;
                continue;
            }

            int k = gcd(Math.abs(a), Math.abs(b));
            long ta = a / k;
            long tb = b / k;

            int keyA = (int)Math.abs(ta);
            int keyB = (int)(ta * tb < 0 ? -Math.abs(tb) : Math.abs(tb));

            AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(keyA, keyB);
            m.put(key, m.getOrDefault(key, 0) + 1);
        }

        long k = N;
        N -= now2 + now3;

        for (Map.Entry<AbstractMap.SimpleEntry<Integer, Integer>, Integer> entry : m.entrySet()) {
            long count = entry.getValue();
            now += count;
            solve += (N - now) * count;
        }

        solve += (k - now2 - now3) * now2;
        solve += (k - now2 - now3) * now3;
        solve += now2 * now3;

        System.out.println(solve);
    }
}
