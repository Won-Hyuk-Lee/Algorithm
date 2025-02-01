import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            BigInteger[] numerators = new BigInteger[N];
            BigInteger[] denominators = new BigInteger[N];
            
            for (int i = 0; i < N; i++) {
                numerators[i] = BigInteger.ZERO;
                denominators[i] = BigInteger.ONE;
            }
            
            for (int j = 0; j < M; j++) {
                int V = scanner.nextInt();
                for (int i = 0; i < N; i++) {
                    int A = scanner.nextInt();
                    if (A > 0) {

                        BigInteger newNum = numerators[i].multiply(BigInteger.valueOf(V))
                                         .add(denominators[i].multiply(BigInteger.valueOf(A)));
                        BigInteger newDen = denominators[i].multiply(BigInteger.valueOf(V));
                        
                        BigInteger gcd = newNum.gcd(newDen);
                        numerators[i] = newNum.divide(gcd);
                        denominators[i] = newDen.divide(gcd);
                    }
                }
            }
            
            BigInteger lcm = denominators[0];
            for (int i = 1; i < N; i++) {
                lcm = lcm.multiply(denominators[i]).divide(lcm.gcd(denominators[i]));
            }
            
            BigInteger max = numerators[0].multiply(lcm.divide(denominators[0]));
            BigInteger min = max;
            
            for (int i = 1; i < N; i++) {
                BigInteger value = numerators[i].multiply(lcm.divide(denominators[i]));
                max = max.max(value);
                min = min.min(value);
            }
            
            BigInteger diffNumerator = max.subtract(min);
            BigInteger diffDenominator = lcm;
            
            BigInteger gcd = diffNumerator.gcd(diffDenominator);
            diffNumerator = diffNumerator.divide(gcd);
            diffDenominator = diffDenominator.divide(gcd);
            
            if (diffDenominator.equals(BigInteger.ONE)) {
                System.out.println(diffNumerator);
            } else {
                System.out.println(diffNumerator + "/" + diffDenominator);
            }
        }
        scanner.close();
    }
}