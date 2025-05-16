import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>(N * 2);
        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) continue;
            int g = gcd(x, y);
            x /= g; y /= g;
            long key = ((long) x << 32) | (y & 0xffffffffL);
            int v = map.getOrDefault(key, 0) + 1;
            map.put(key, v);
            if (v > max) max = v;
        }
        System.out.print(max);
    }
}
