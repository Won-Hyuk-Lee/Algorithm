import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    int r, c;
    int[][] arr;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < c; j++) {
            int columnIdx = findColumn(j + 1);
            if (columnIdx < j) {
                System.out.println(0);
                return;
            }
            swapColumn(j, columnIdx);
        }

        for (int i = 0; i < r; i++) {
            int rowIdx = findRow(i * c + 1);
            if (rowIdx < i) {
                System.out.println(0);
                return;
            }
            swapRow(i, rowIdx);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != i * c + j + 1) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }

    private void swapColumn(int j, int includeIdx) {
        for (int i = 0; i < r; i++) {
            int tmp = arr[i][j];
            arr[i][j] = arr[i][includeIdx];
            arr[i][includeIdx] = tmp;
        }
    }

    private void swapRow(int i, int includeIdx) {
        for (int j = 0; j < c; j++) {
            int tmp = arr[i][j];
            arr[i][j] = arr[includeIdx][j];
            arr[includeIdx][j] = tmp;
        }
    }

    private int findColumn(int value) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == value) return j;
            }
        }
        return -1;
    }

    private int findRow(int value) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == value) return i;
            }
        }
        return -1;
    }
}