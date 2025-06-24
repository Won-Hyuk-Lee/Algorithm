import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1]; // 1-based index
            boolean[] visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            int cycleCount = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    int cur = i;
                    while (!visited[cur]) {
                        visited[cur] = true;
                        cur = arr[cur];
                    }
                    cycleCount++;
                }
            }

            int swapCount = n - cycleCount;
            System.out.println(swapCount % 2 == 0 ? "YES" : "NO");
        }
    }
}
