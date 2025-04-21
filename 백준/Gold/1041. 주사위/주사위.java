import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] dice = new long[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Long.parseLong(st.nextToken());
        }
        
        if (n == 1) {
            Arrays.sort(dice);
            long sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += dice[i];
            }
            System.out.println(sum);
            return;
        }
        
        long min1 = Arrays.stream(dice).min().getAsLong();
        
        long min2 = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    min2 = Math.min(min2, dice[i] + dice[j]);
                }
            }
        }
        
        long min3 = 0;
        for (int i = 0; i < 3; i++) {
            min3 += Math.min(dice[i], dice[5 - i]);
        }
        
        long faces1 = 5 * (n - 2) * (n - 2) + 4 * (n - 2);
        long faces2 = 8 * (n - 2) + 4;
        long faces3 = 4;
        
        long result = min1 * faces1 + min2 * faces2 + min3 * faces3;
        System.out.println(result);
    }
}