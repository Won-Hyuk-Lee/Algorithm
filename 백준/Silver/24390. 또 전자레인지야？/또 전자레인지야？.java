import java.io.*;
import java.util.*;

public class Main {
    private static final int[] BUTTON = {10, 60, 600, 30};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(":");
        int sec = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        System.out.println(cal(sec));
    }
    
    private static int cal(int target) {
        if (target == 30) return 1;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        int time = 0;
        
        while (!q.isEmpty()) {
            for (int s = 0, size = q.size(); s < size; s++) {
                int now = q.poll();
                if (now / 10 == target) 
                    return time + (now % 10 == 1 ? 0 : 1);
                
                for (int i = 0; i < 4; i++) {
                    int next = now + 10 * BUTTON[i];
                    if (i == 3) next += next % 10 == 0 ? 1 : 0;
                    
                    if (!visited.contains(next) && next / 10 <= target) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}