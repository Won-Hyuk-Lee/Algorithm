import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, Long> memo = new HashMap<>();
    static int p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        System.out.println(solve(n));
    }

    static long solve(long n) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        long result = solve(n / p) + solve(n / q);
        memo.put(n, result);
        return result;
    }
}
