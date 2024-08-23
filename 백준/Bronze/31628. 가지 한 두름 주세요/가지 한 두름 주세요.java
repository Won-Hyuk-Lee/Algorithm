import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[][] grid = new String[10][10];
        
        //10x10
        for (int i = 0; i < 10; i++) {
            grid[i] = br.readLine().split(" ");
        }
        
        //가로 확인
        for (int i = 0; i < 10; i++) {
            boolean rowSame = true;
            String firstColor = grid[i][0];
            for (int j = 1; j < 10; j++) {
                if (!grid[i][j].equals(firstColor)) {
                    rowSame = false;
                    break;
                }
            }
            //가로가 모두 같으면 1
            if (rowSame) {
                System.out.println(1);
                return;
            }
        }
        
        //세로 확인
        for (int i = 0; i < 10; i++) {
            boolean colSame = true;
            String firstColor = grid[0][i];
            for (int j = 1; j < 10; j++) {
                if (!grid[j][i].equals(firstColor)) {
                    colSame = false;
                    break;
                }
            }
            //세로가 모두 같으면 1
            if (colSame) {
                System.out.println(1);
                return;
            }
        }
        
        //둘다 다르면0
        System.out.println(0);
    }
}
