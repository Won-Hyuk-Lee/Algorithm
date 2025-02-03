import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] sum = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                sum[j] += Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= m; i++) {
            sum[i] += sum[i - 1];
        }
        
        int a = Integer.parseInt(br.readLine());
        int max = 0;
        
        for (int i = a; i <= m; i++) {
            max = Math.max(max, sum[i] - sum[i - a]);
        }
        
        System.out.print(max);
    }
}