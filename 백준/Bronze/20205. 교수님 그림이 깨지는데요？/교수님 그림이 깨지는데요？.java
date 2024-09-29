import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N은 비트맵의 가로/세로, K는 배율
        int N = sc.nextInt();
        int K = sc.nextInt();

        //비트맵 배열
        int[][] bitmap = new int[N][N];

        //비트맵 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bitmap[i][j] = sc.nextInt();
            }
        }

        //업샘플링된 비트맵 출력
        for (int i = 0; i < N; i++) {
            for (int l = 0; l < K; l++) {
                for (int j = 0; j < N; j++) {
                    for (int m = 0; m < K; m++) {
                        System.out.print(bitmap[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
