import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if (k == 0) {
            System.out.println(n);
            return;
        }
        
        long[][] intervals = new long[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            intervals[i][0] = Long.parseLong(st.nextToken());
            intervals[i][1] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });
        
        TreeMap<Long, Long> dp = new TreeMap<>();
        dp.put(0L, 0L);
        
        long maxCoverage = 0;
        
        for (int i = 0; i < k; i++) {
            long start = intervals[i][0];
            long end = intervals[i][1];
            long length = end - start + 1;
            
            Map.Entry<Long, Long> entry = dp.floorEntry(start - 1);
            long prevMax = (entry != null) ? entry.getValue() : 0;
            
            long newCoverage = prevMax + length;
            maxCoverage = Math.max(maxCoverage, newCoverage);
            
            Map.Entry<Long, Long> lastEntry = dp.lastEntry();
            if (lastEntry == null || lastEntry.getValue() < newCoverage) {
                dp.put(end, newCoverage);
                
                while (true) {
                    Map.Entry<Long, Long> higher = dp.higherEntry(end);
                    if (higher != null && higher.getValue() <= newCoverage) {
                        dp.remove(higher.getKey());
                    } else {
                        break;
                    }
                }
            }
        }
        
        System.out.println(n - maxCoverage);
    }
}