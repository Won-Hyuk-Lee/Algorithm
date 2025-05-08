import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int s = 0, e = 0, sum = 0, count = 0;
        while (true) {
            if (sum >= n) {
                if (sum == n) count++;
                sum -= primes.get(s++);
            } else {
                if (e == primes.size()) break;
                sum += primes.get(e++);
            }
        }

        System.out.println(count);
    }
}
