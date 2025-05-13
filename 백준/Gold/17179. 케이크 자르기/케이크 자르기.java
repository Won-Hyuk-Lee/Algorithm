import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
        int M = Integer.parseInt(st.nextToken()); // 자를 수 있는 지점 수
        int L = Integer.parseInt(st.nextToken()); // 케이크 길이

        int[] positions = new int[M + 1];
        for (int i = 0; i < M; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        positions[M] = L;

        for (int t = 0; t < N; t++) {
            int cuts = Integer.parseInt(br.readLine());

            int left = 1;
            int right = L;
            int result = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (canCut(positions, mid, cuts)) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(result);
        }
    }

    static boolean canCut(int[] positions, int minLen, int cutsAllowed) {
        int count = 0;
        int prev = 0;
        for (int p : positions) {
            if (p - prev >= minLen) {
                count++;
                prev = p;
            }
        }
        return count > cutsAllowed;
    }
}
