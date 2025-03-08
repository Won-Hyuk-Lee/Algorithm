import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        long answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            answer += arr[i];
        }
        bw.write(answer + "\n");
        
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            if (num == 1) {
                int temp = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (!visited[temp]) {
                    answer += x - arr[temp];
                }
                arr[temp] = x;
            } else {
                int x = Integer.parseInt(st.nextToken());
                visited[x] = !visited[x];
                answer += visited[x] ? -arr[x] : arr[x];
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}