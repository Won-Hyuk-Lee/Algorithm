import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int a;
        if (n != 2) {
            a = (arr[1][0] - arr[2][1] + arr[2][0]) / 2;
        } else {
            a = 1;
        }

        System.out.print(a + " ");
        for (int i = 1; i < n; i++) {
            System.out.print((arr[0][i] - a) + " ");
        }
    }
}
