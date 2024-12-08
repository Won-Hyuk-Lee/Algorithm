import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    ArrayList<int[]> queen;
    int rowCnt, colCnt;

    private boolean chk(int i, int j) {
        if (((rowCnt ^= 1 << i) & (1 << i)) == 0) return false;
        if (((colCnt ^= 1 << j) & (1 << j)) == 0) return false;
        for (int[] q : queen) {
            if (Math.abs(q[0] - i) == Math.abs(q[1] - j)) return false;
        }
        queen.add(new int[]{i, j});
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queen = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) == '*') {
                    cnt++;
                    if (!chk(i, j)) {
                        System.out.println("invalid");
                        return;
                    }
                }
            }
        }
        System.out.println(cnt == 8 ? "valid" : "invalid");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
