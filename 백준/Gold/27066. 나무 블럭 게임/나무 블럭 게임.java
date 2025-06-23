import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            sum += v[i];
        }

        Arrays.sort(v);
        double avg = (double) sum / n;
        double result;

        if (n == 1) {
            result = avg;
        } else {
            result = Math.max(avg, v[n - 2]);
        }

        System.out.printf("%.7f\n", result);
    }
}
