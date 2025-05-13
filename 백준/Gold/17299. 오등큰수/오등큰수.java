import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] freq = new int[MAX];
        int[] res = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && freq[arr[stack.peek()]] < freq[arr[i]]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int v : res) sb.append(v).append(" ");
        System.out.println(sb);
    }
}
