import java.io.*;
import java.util.*;

public class Main {
    static int n, d = 0; // 보드 크기와 현재 방향
    static int[][] map; // 사과 위치
    static Map<Integer, String> moveInfo; // 방향 전환 정보
    static int[] dx = {1, 0, -1, 0}; // 방향 배열 (동, 남, 서, 북)
    static int[] dy = {0, 1, 0, -1}; // 방향 배열 (동, 남, 서, 북)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine()); // 보드 크기
        int k = Integer.parseInt(br.readLine()); // 사과 개수
        map = new int[n][n];
        moveInfo = new HashMap<>();

        // 사과 위치 입력
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
        }

        int l = Integer.parseInt(br.readLine()); // 방향 전환 정보 개수
        // 방향 전환 정보 입력
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            moveInfo.put(time, direction);
        }

        solve(); // 게임 시작
    }

    static void solve() {
        Queue<Integer> snake = new LinkedList<>(); // 뱀의 위치를 저장하는 큐
        snake.add(0); // 뱀의 시작 위치
        int time = 0;
        int px = 0, py = 0; // 뱀의 현재 위치

        while (true) {
            int nx = px + dx[d]; // 다음 위치 x
            int ny = py + dy[d]; // 다음 위치 y
            time++;

            // 벽에 부딪힘
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                break;
            }

            // 몸통에 부딪힘
            if (snake.contains(ny * n + nx)) {
                break;
            }

            // 사과가 있으면 사과 먹고 뱀 길이 증가
            if (map[ny][nx] == 1) {
                map[ny][nx] = 0;
                snake.add(ny * n + nx);
            } else
            { 
                snake.add(ny * n + nx); // 사과가 없으면 이동만
                snake.poll(); // 꼬리 위치 이동
            }

            // 시간에 따른 방향 전환
            if (moveInfo.containsKey(time)) {
                String data = moveInfo.get(time);
                if (data.equals("D")) {
                    d = (d + 1) % 4; // 오른쪽 회전
                } else {
                    d = (d + 3) % 4; // 왼쪽 회전 (d - 1과 동일)
                }
            }

            // 현재 위치 갱신
            px = nx;
            py = ny;
        }

        System.out.println(time); // 게임 종료 시점의 시간 출력
    }
}

