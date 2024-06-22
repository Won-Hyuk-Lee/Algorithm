import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BitSet check;
    static int[][] arr;
    
    static int node, line, start;
    
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        
        arr = new int[node+1][node+1];
        check = new BitSet(node+1);
        
        for(int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            
            arr[a][b] = arr[b][a] = 1;    
        }

        // 깊이 우선 탐색 시작
        dfs(start);
        sb.append("\n");

        // 방문 체크 초기화
        check.clear();

        // 너비 우선 탐색 시작
        bfs(start);
        
        // 결과 출력
        System.out.println(sb);
    }

    // 깊이우선 (DFS)
    public static void dfs(int start) {
        check.set(start);
        sb.append(start).append(" ");
        
        for(int i = 1; i <= node; i++) {
            if(arr[start][i] == 1 && !check.get(i))
                dfs(i);
        }
    }
    
    // 너비우선 (BFS)
    public static void bfs(int start) {
        q.add(start);
        check.set(start);
        
        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");
            
            for(int i = 1; i <= node; i++) {
                if(arr[current][i] == 1 && !check.get(i)) {
                    q.add(i);
                    check.set(i);
                }
            }
        }
    }

}
