import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        BigInteger result = binomialCoefficient(n, m);
        System.out.println(result);
    }

    private static BigInteger binomialCoefficient(int n, int m) {
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            res = res.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
        }
        return res;
    }
}
