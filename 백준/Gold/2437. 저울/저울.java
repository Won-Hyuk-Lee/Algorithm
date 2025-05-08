import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(w);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] > sum + 1) break;
            sum += w[i];
        }
        System.out.println(sum + 1);
    }
}
