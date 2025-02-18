import java.util.Scanner;

public class Main {

    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int answer;
    
    static int[] moveR = {1, -1, 0, 0};
    static int[] moveC = {0, 0, 1, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        
        System.out.println(answer);
    }
    
    static void dfs(int r, int c, int moved) {
        if (r == 0 && c == C - 1) {
            if (moved == K) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nextR = r + moveR[i];
            int nextC = c + moveC[i];
            
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC] || map[nextR][nextC] == 'T') {
                continue;
            }
            
            visited[nextR][nextC] = true;
            dfs(nextR, nextC, moved + 1);
            visited[nextR][nextC] = false;
        }
    }
}
