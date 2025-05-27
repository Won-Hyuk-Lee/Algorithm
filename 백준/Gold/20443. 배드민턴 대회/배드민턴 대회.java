import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100;
    static long[] derangement = new long[MAX + 1];
    static long[] factorial = new long[MAX + 1];
    static long[] invFactorial = new long[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        precomputeFactorials();
        precomputeDerangement();

        long result = 0;
        for (int k = 0; k <= 3; k++) {
            int M = N - k;
            if (M >= 0 && M % 4 == 0) {
                long combinations = nCr(N, k);
                result = (result + combinations * derangement[M]) % MOD;
            }
        }

        System.out.println(result);
    }

    static void precomputeFactorials() {
        factorial[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        invFactorial[MAX] = modInverse(factorial[MAX]);
        for (int i = MAX - 1; i >= 0; i--) {
            invFactorial[i] = (invFactorial[i + 1] * (i + 1)) % MOD;
        }
    }

    static void precomputeDerangement() {
        derangement[0] = 1;
        if (MAX >= 1) derangement[1] = 0;
        for (int i = 2; i <= MAX; i++) {
            derangement[i] = ((i - 1) * (derangement[i - 1] + derangement[i - 2])) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((factorial[n] * invFactorial[r]) % MOD) * invFactorial[n - r]) % MOD;
    }

    static long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
