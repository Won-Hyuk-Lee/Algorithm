import java.util.*;
import java.io.*;

public class Main {
    //방향 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static int[][] field;
    static boolean[][] visited;
    static int width, height, cabbageCount;
    static int wormCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());
        
        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            cabbageCount = Integer.parseInt(st.nextToken());

            //배추밭과 방문 배열
            field = new int[height][width];
            visited = new boolean[height][width];

            //배추위치
            for (int i = 0; i < cabbageCount; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            wormCount = 0;
            //전체 배추밭 DFS 순회
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        iterativeDFS(j, i);
                        wormCount++;
                    }
                }
            }

            sb.append(wormCount).append('\n');
        }

        System.out.print(sb);
    }

    //반복적 DFS 구현
    //재귀X스택으로 구현
    static void iterativeDFS(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[y][x] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currentX = current[0];
            int currentY = current[1];

            //상하좌우
            for (int i = 0; i < 4; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                //유효한 범위이면서 미방문 배추가 있는 경우
                if (isValidRange(newX, newY) && field[newY][newX] == 1 && !visited[newY][newX]) {
                    stack.push(new int[]{newX, newY});
                    visited[newY][newX] = true;
                }
            }
        }
    }

    //유효좌표범위확인
    static boolean isValidRange(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}