import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int target = arr[i], l = 0, r = n - 1;
            while (l < r) {
                if (l == i) l++;
                else if (r == i) r--;
                else {
                    int sum = arr[l] + arr[r];
                    if (sum == target) {
                        count++;
                        break;
                    } else if (sum < target) l++;
                    else r--;
                }
            }
        }
        System.out.println(count);
    }
}
