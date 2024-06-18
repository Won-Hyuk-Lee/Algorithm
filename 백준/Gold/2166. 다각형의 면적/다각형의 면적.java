import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 다각형의 점 개수 N
        int N = Integer.parseInt(br.readLine());

        // 좌표를 저장할 배열
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        long sum_a = 0, sum_b = 0;

        // 각 좌표 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        // 첫 점을 마지막 점으로 복사하여 다각형으로
        x[N] = x[0];
        y[N] = y[0];

        // 다각형 면적 계산
        for (int i = 0; i < N; i++) {
            sum_a += x[i] * y[i + 1];
            sum_b += x[i + 1] * y[i];
        }

        // 면적을 소수 첫째 자리까지
        String area = String.format("%.1f", (Math.abs(sum_a - sum_b) / 2.0));
        bw.write(area);

        br.close();
        bw.flush();
        bw.close();
    }
}
