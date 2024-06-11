import java.util.*;
import java.io.*;

public class Main {
    static long a, b;
    static int cnt;
    
    // 알고리즘 구분에 너비우선탐색(BFS)라고 되어있으므로 힌트를 얻음
    
    
    static int bfs() // BFS 알고리즘을 사용하여 최소 연산 횟수를 찾음
    {
        Queue<Long> q = new LinkedList<>(); // long이 아니면 오버됨
        q.add(a);

        while (!q.isEmpty()) {
            int size = q.size();

            // 현재 큐에 있는 모든 요소를 탐색
            for (int i = 0; i < size; i++) {
                long tmp = q.poll(); // 큐에서 요소를 꺼냄
                if (tmp == b)
                    return cnt + 1; // 목표값에 도달하면 연산 횟수 반환

                // tmp * 2가 b 이하일 경우 큐에 추가
                if (tmp * 2 <= b) q.add(tmp * 2);
                // tmp * 10 + 1이 b 이하일 경우 큐에 추가
                if (tmp * 10 + 1 <= b) q.add(tmp * 10 + 1);
            }
            cnt++; // 각 레벨이 끝날 때마다 연산 횟수 증가
        }
        return -1; // b에 도달할 수 없는 경우 -1 반환
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());

        a = Long.parseLong(stk.nextToken());
        b = Long.parseLong(stk.nextToken());

        System.out.println(bfs()); // bfs 결과 출력
    }
}
