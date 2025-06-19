import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long minValue = Long.MAX_VALUE;
    static int num = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] crossArr = new int[N];
        int[] leftArr = new int[N - 1];
        int[] rightArr = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            crossArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            leftArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            rightArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            long min = crossArr[i];
            for (int left = 0; left < i; left++) {
                min += leftArr[left];
            }
            for (int right = i; right < N - 1; right++) {
                min += rightArr[right];
            }
            if (minValue > min) {
                minValue = min;
                num = i + 1;
            }
        }
        sb.append(num).append(' ').append(minValue);
        System.out.println(sb);
    }
}