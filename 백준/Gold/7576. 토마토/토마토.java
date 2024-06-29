import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    //일단 인접한 것부터 탐색 = bfs를 생각했다.
    //근데 알고리즘 분류에 너비 우선 탐색이라는 힌트가 보였다.
    //그래서 bfs를 이용하기로 했고 큐를 함께 사용했다.
    
    static int N, M; //상자의 세로N과 가로M
    static int[][] box; //토마토 상자
    static int[] dx = {1, -1, 0, 0}; //상하좌우 방향
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>(); //다형성 LinkedList가 Queue의 동작을 충분히 가능
                                                    //LinkedList의 추가 및 삭제의 시간복잡도는 o(1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j}); //익은 토마토의 위치 큐에
                }
            }
        }
        
        int days = bfs();
        
        if (checkAllRipen()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
    
    static int bfs() {
        int days = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll();
                int x = tomato[0];
                int y = tomato[1];
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (box[nx][ny] == 0) { //익지 않은 토마토이면
                            box[nx][ny] = 1; //익힌다
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            
            days++; //하루 ++
        }
        
        return days - 1; //마지막에 날짜 하나 더 증가되므로 하루를 --
    }
    
    static boolean checkAllRipen() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false; // 아직 익지 않은 토마토가 있다.
                }
            }
        }
        return true; // 모든 토마토가 익었다.
    }
}
