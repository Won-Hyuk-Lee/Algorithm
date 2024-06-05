import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());

        // n개의 정수 배열
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정수 배열 오름차순
        Arrays.sort(arr);

        // m 입력
        int m = Integer.parseInt(br.readLine());

        // 결과 저장 StringBuilder
        StringBuilder sb = new StringBuilder();

        // m개의 입력 받고 n개의 정수 배열에 존재하는지 확인하여 결과를 StringBuilder에 추가
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 이진 탐색으로 m개의 수가 n개의 정수 배열에 존재하는지 확인
            int in = Arrays.binarySearch(arr, num);

            if (in < 0) {
                sb.append(0).append('\n'); // 존재하지 않으면 0을 StringBuilder에 추가
            } else {
                sb.append(1).append('\n'); // 존재하면 1을 StringBuilder에 추가
            }
        }
        System.out.println(sb);
    }
}
