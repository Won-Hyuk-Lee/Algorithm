import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int maxReq = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxReq = Math.max(maxReq, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int left = 0, right = maxReq, result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;
            for (int a : arr) total += Math.min(a, mid);

            if (total <= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
