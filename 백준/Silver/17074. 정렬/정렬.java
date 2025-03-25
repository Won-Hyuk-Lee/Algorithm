import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;

    public static int solution() {
        int hill = 0;
        int index = -1;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                index = i;
                hill++;
            }
        }

        if (hill == 0) return N;
        if (hill > 1) return 0;

        if (index == 0) {
            return (N > 2 && arr[index] <= arr[index + 2]) ? 2 : 1;
        }

        if (index == N - 2) {
            return arr[index - 1] <= arr[index + 1] ? 2 : 1;
        }

        int count = 0;
        if (arr[index - 1] <= arr[index + 1]) count++;
        if (index + 2 < N && arr[index] <= arr[index + 2]) count++;

        return count;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
}
