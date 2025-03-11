import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 1299709;
    static int[] primes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        primes = sieve(MAX);
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(findPrimeGap(num)).append("\n");
        }
        System.out.print(sb);
    }
    
    static int[] sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int findPrimeGap(int N) {
        int idx = Arrays.binarySearch(primes, N);
        if (idx >= 0) return 0;
        idx = -idx - 1;
        return primes[idx] - primes[idx - 1];
    }
}