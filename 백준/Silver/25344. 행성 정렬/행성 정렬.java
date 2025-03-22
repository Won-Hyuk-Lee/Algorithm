import java.io.*;
import java.util.*;

public class Main {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long lcm = Long.parseLong(st.nextToken());
        for (int i = 1; i < n - 2; i++) {
            long x = Long.parseLong(st.nextToken());
            lcm = lcm * x / gcd(lcm, x);
        }

        System.out.println(lcm);
    }
}
