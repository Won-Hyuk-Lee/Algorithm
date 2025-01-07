import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int MOD = 15746;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(calculateTiling(n));
    }
    
    private static int calculateTiling(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        
        int prev2 = 1;
        int prev1 = 2;
        int current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}