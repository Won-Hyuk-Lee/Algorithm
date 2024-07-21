import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long result = combination(n, k);
        
        System.out.println(result);
    }

    private static long combination(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
