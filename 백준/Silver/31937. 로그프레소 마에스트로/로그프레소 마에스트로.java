import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        boolean[] infected = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            infected[Integer.parseInt(st.nextToken())] = true;
        }
        
        int[][] logs = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            logs[i][0] = Integer.parseInt(st.nextToken());
            logs[i][1] = Integer.parseInt(st.nextToken());
            logs[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        
        int answer = 0;
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            
            for (int[] log : logs) {
                if (visited[log[1]]) {
                    visited[log[2]] = true;
                }
            }
            
            boolean match = true;
            for (int j = 1; j <= N; j++) {
                if (visited[j] != infected[j]) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                answer = i;
                break;
            }
        }
        
        System.out.println(answer);
    }
}