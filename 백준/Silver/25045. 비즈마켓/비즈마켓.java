import java.io.*;
import java.util.*;

public class Main {
    static class DescendOrder implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            return Long.compare(o2, o1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Long> productsPq = new PriorityQueue<>(new DescendOrder());
        PriorityQueue<Long> clientsPq = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            productsPq.add(Long.parseLong(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            clientsPq.add(Long.parseLong(st.nextToken()));
        }
        
        long answer = 0;
        while (!clientsPq.isEmpty() && !productsPq.isEmpty()) {
            long product = productsPq.poll();
            long client = clientsPq.poll();
            if (product < client) break;
            answer += (product - client);
        }
        
        System.out.println(answer);
        br.close();
    }
}
