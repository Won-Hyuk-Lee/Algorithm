import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Queue<Integer> queue = new LinkedList<>();
        
        //n
        int n = Integer.parseInt(br.readLine());
        
        // 1부터 n까지의 숫자 큐에 추가
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        // 큐의 크기가 1이 될 때까지
        while(queue.size() > 1) {
            // 첫 번째 숫자를 제거
            queue.poll();
            // 그 다음 숫자를 큐의 끝으로 이동
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
