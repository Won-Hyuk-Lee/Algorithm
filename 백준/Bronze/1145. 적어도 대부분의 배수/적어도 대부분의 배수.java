import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr = new int[5];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            arr[i] = stoi(st.nextToken());
        }

        N = Arrays.stream(arr).min().getAsInt();

        while (true) {
            int count = 0;

            for (int num : arr) {
                if (N >= num && N % num == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                break;
            }

            N++;
        }

        System.out.println(N);
    }
}