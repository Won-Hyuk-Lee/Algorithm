import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[][] paper = new boolean[100][100]; // 전체 하얀 종이는 100 * 100으로 총 10000의 넓이
        int count = scanner.nextInt(); // 검은종이의 갯수

        // count 수 만큼 입력받기
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt(); // 열 가로
            int b = scanner.nextInt(); // 행 세로
            for (int j = a; j < a + 10; j++) {
            // 사각형 부분에 1을 넣어주기
                for (int k = b; k < b + 10; k++) {
                    paper[k][j] = true;
                }
            }

        }

        // 2차원 배열 출력. 1인 숫자만 더하기.
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == true) {
                    result += 1;
                }
            }
        }
        System.out.println(result);

    }
}