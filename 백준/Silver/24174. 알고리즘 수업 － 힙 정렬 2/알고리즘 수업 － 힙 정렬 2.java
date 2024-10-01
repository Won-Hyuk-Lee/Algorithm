import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int targetCnt;
    private static int cnt = 0;
    private static boolean flag = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        targetCnt = Integer.parseInt(st.nextToken()); // 타겟으로 하는 스왑 횟수

        int[] arr = new int[N + 1]; // 배열 선언 (인덱스 1부터 사용)
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 초기화
        }

        heapSort(arr); // 힙 정렬 수행

        if (!flag) { // 타겟 횟수에 도달하지 못했을 경우
            bw.write(String.valueOf(-1)); // -1 출력
            bw.flush();
        }
        bw.close();
        br.close();
    }

    // 배열 요소 스왑하고 타겟 횟수 체크하는 메소드
    static void swap(int[] arr, int a, int b) throws IOException {
        cnt++; // 스왑 횟수 증가

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

        if (cnt == targetCnt) { // 타겟 횟수에 도달했을 경우
            for (int i = 1; i < arr.length; i++) {
                bw.write(arr[i] + " "); // 결과 출력
            }
            bw.flush();
            flag = true; // flag를 true로 설정하여 결과를 출력했음을 표시
        }
    }

    // 힙 정렬 수행하는 메소드
    static void heapSort(int[] arr) throws IOException {
        buildMinHeap(arr, arr.length - 1); // 최소 힙으로 정렬
        for (int i = arr.length - 1; i > 1; i--) {
            swap(arr, 1, i); // 루트와 마지막 요소 스왑
            heapify(arr, 1, i - 1); // 힙 속성 유지
        }
    }

    // 최소 힙으로 만드는 메소드
    static void buildMinHeap(int[] arr, int N) throws IOException {
        for (int i = N / 2; i >= 1 && !flag; i--) {
            heapify(arr, i, N); // 힙 속성 유지
        }
    }

    // 힙 속성 유지하며 요소 교환하는 메소드
    static void heapify(int[] arr, int K, int N) throws IOException {
        int left = 2 * K;
        int right = 2 * K + 1;
        int smaller;

        if (right <= N) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= N) {
            smaller = left;
        } else {
            return; // 인덱스 범위를 벗어나면 종료
        }

        if (arr[smaller] < arr[K]) {
            swap(arr, K, smaller); // 힙 속성이 위배되면 스왑
            heapify(arr, smaller, N); // 재귀적으로 힙 속성 유지
        }
    }
}