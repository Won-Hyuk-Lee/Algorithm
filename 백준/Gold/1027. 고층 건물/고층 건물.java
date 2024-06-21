import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] buildings; // 건물들 높이
    static int[] answer; // 보이는 건물의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // 각 건물에 대해 오른쪽 건물만 탐색
        for (int i = 0; i < N - 1; i++) {
            // 해당 index의 오른쪽 건물은 무조건 보임
            answer[i]++;
            // 해당 index의 오른쪽 건물은 해당 index 건물이 보임
            answer[i + 1]++;
            // 초기 기울기
            double slope = (double) (buildings[i + 1] - buildings[i]) / 1;
            // 해당 index+2부터 오른쪽만 탐색 시작
            for (int j = i + 2; j < N; j++) {
                double nextSlope = calculateSlope(i, j);
                if (nextSlope > slope) {
                    slope = nextSlope;
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answer.length; i++) {
            max = Math.max(max, answer[i]);
        }

        System.out.println(max);
    }

    static double calculateSlope(int i, int j) {
        return (double) (buildings[j] - buildings[i]) / (j - i);
    }
}
