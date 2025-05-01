import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();
            
            int start = Integer.parseInt(x.substring(0, 2)) * 60 + Integer.parseInt(x.substring(2, 4));
            int end = Integer.parseInt(y.substring(0, 2)) * 60 + Integer.parseInt(y.substring(2, 4));
            
            pq.add(new int[]{start, end});
        }
        
        int result = pq.peek()[0] - 10 - 600;
        int[] temp = null;
        
        while (!pq.isEmpty()) {
            temp = pq.poll();
            temp[1] += 10;
            
            while (!pq.isEmpty() && temp[1] >= pq.peek()[0] - 10) {
                temp[1] = Math.max(pq.poll()[1] + 10, temp[1]);
            }
            
            if (!pq.isEmpty()) {
                result = Math.max(result, pq.peek()[0] - 10 - temp[1]);
            }
        }
        
        result = Math.max(result, 22 * 60 - temp[1]);
        result = Math.max(result, 0);
        
        System.out.println(result);
    }
}