import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = bf.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        long[] arr = new long[n];
        int idx = 0;

        for (int i = 1; i < firstLine.length && idx < n; i++) {
            if (!firstLine[i].isEmpty()) {
                arr[idx++] = reverseParseLong(firstLine[i]);
            }
        }

        while (idx < n) {
            String[] tokens = bf.readLine().split(" ");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    arr[idx++] = reverseParseLong(token);
                    if (idx >= n) break;
                }
            }
        }

        Arrays.sort(arr);

        for (long num : arr) {
            bw.write(num + "\n");
        }
        bw.flush();
    }

    private static long reverseParseLong(String str) {
        return Long.parseLong(new StringBuilder(str).reverse().toString());
    }
}
