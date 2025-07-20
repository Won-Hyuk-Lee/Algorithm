import java.io.*;
import java.util.*;

public class Main {
    static int n, t, w, m;
    static Queue<Customer> q = new LinkedList<>();
    static PriorityQueue<Customer> customerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new Customer(Integer.parseInt(st.nextToken()), 
                               Integer.parseInt(st.nextToken()), 0));
        }

        m = Integer.parseInt(br.readLine());
        customerList = new PriorityQueue<>((o1, o2) -> o1.inputTime - o2.inputTime);
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            customerList.offer(new Customer(Integer.parseInt(st.nextToken()),
                                          Integer.parseInt(st.nextToken()),
                                          Integer.parseInt(st.nextToken())));
        }

        System.out.print(roundRobin());
    }

    public static StringBuilder roundRobin() {
        StringBuilder sb = new StringBuilder();
        int currentTime = 0;
        
        while(currentTime < w && !q.isEmpty()) {
            Customer current = q.poll();
            int executeTime = Math.min(current.time, t);
            
            for(int i = 0; i < executeTime && currentTime < w; i++) {
                sb.append(current.num).append('\n');
                currentTime++;
            }

            while(!customerList.isEmpty() && customerList.peek().inputTime <= currentTime) {
                q.offer(customerList.poll());
            }

            if(current.time > t) {
                current.time -= t;
                q.offer(current);
            }
        }
        return sb;
    }

    static class Customer {
        int num, time, inputTime;

        Customer(int num, int time, int inputTime) {
            this.num = num;
            this.time = time;
            this.inputTime = inputTime;
        }
    }
}