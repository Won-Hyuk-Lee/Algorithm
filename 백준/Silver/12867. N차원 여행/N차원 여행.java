import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        
        long[] indexes = new long[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            indexes[i] = Long.parseLong(st.nextToken());
        }
        
        String moves = br.readLine();
        
        Map<Long, Integer> current = new HashMap<>();
        List<Map<Long, Integer>> path = new ArrayList<>();
        
        path.add(new HashMap<>());
        
        for (int i = 0; i < m; i++) {
            int direction = (moves.charAt(i) == '+') ? 1 : -1;
            long index = indexes[i];
            
            int newValue = current.getOrDefault(index, 0) + direction;
            if (newValue == 0) {
                current.remove(index);
            } else {
                current.put(index, newValue);
            }
            
            for (Map<Long, Integer> previous : path) {
                if (current.equals(previous)) {
                    System.out.println("0");
                    return;
                }
            }
            
            path.add(new HashMap<>(current));
        }
        
        System.out.println("1");
    }
}