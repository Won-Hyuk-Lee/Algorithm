import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static boolean[][] arr;
    public static int min = 64;  // 최솟값을 저장하기 위한 변수, 초기값은 체스판 전체 크기인 64로 설정

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        // 배열 입력 처리
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                // 'w'일 경우 true, 'b'일 경우 false로 설정
                arr[i][j] = str.charAt(j) == 'W';
            }
        }

        // 체스판의 가능한 시작 지점의 행과 열의 범위 계산
        int n_row = n - 7;
        int m_col = m - 7;

        // 모든 가능한 8x8 체스판을 검사
        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_col; j++) {
                // 현재 시작 지점에서의 최솟값을 계산
                find(i, j);
            }
        }
        System.out.println(min);
    }

    // 8x8 체스판의 색칠 변경 횟수를 계산하는 메서드
    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count1 = 0;  // 첫 번째 칸이 'W'인 경우의 색칠 변경 횟수
        int count2 = 0;  // 첫 번째 칸이 'B'인 경우의 색칠 변경 횟수

        // (x, y)부터 8x8 체스판을 검사
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 현재 칸이 기준 패턴과 맞지 않을 경우 색칠 변경 횟수 증가
                if ((i + j) % 2 == 0) {  // 짝수 합일 경우 첫 번째 칸과 같은 색이어야 한다
                    if (arr[i][j]) {
                        count2++;
                    } else {
                        count1++;
                    }
                } else {  // 홀수 합일 경우 첫 번째 칸과 다른 색이어야 한다
                    if (arr[i][j]) {
                        count1++;
                    } else {
                        count2++;
                    }
                }
            }
        }
        
        // 더 적은 변경 횟수를 선택
        int count = Math.min(count1, count2);
        
        // 최솟값 갱신
        min = Math.min(min, count);
    }
}
