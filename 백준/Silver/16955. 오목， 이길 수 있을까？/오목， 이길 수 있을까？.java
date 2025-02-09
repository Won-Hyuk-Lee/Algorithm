import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[10][10];
        
        for (int i = 0; i < 10; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == '.' && isWinningMove(arr, i, j)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean isWinningMove(char[][] arr, int r, int c) {
        int[][] directions = {{0, 1}, {1, 0}, {1, -1}, {1, 1}};
        
        for (int[] d : directions) {
            int cnt = countConsecutive(arr, r, c, d[0], d[1]) + countConsecutive(arr, r, c, -d[0], -d[1]);
            if (cnt >= 4) return true;
        }
        return false;
    }
    
    private static int countConsecutive(char[][] arr, int r, int c, int dr, int dc) {
        int cnt = 0;
        for (int i = 1; i < 5; i++) {
            int nr = r + dr * i, nc = c + dc * i;
            if (nr < 0 || nr >= 10 || nc < 0 || nc >= 10 || arr[nr][nc] != 'X') break;
            cnt++;
        }
        return cnt;
    }
}