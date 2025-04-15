import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Queue<Integer>[] Q = new LinkedList[3];
        
        for (int i = 0; i < 3; i++) {
            Q[i] = new LinkedList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Q[arr[i] % 3].offer(arr[i]);
        }
        
        if (Q[0].size() > (n + 1) / 2 || (Q[0].isEmpty() && !Q[1].isEmpty() && !Q[2].isEmpty())) {
            System.out.print(-1);
            return;
        }
        
        while (!Q[1].isEmpty()) {
            if (Q[0].size() > 1) {
                sb.append(Q[0].poll()).append(" ");
            }
            sb.append(Q[1].poll()).append(" ");
        }
        
        if (!Q[0].isEmpty()) {
            sb.append(Q[0].poll()).append(" ");
        }
        
        while (!Q[2].isEmpty()) {
            sb.append(Q[2].poll()).append(" ");
            if (!Q[0].isEmpty()) {
                sb.append(Q[0].poll()).append(" ");
            }
        }
        
        System.out.print(sb);
    }
}