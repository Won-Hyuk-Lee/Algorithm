import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[][] input = new String[9][9];
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                input[i][j] = st.nextToken();
            }
        }
        
        var map = new TreeMap<String, Integer>();
        TreeSet<String>[] set = (TreeSet<String>[]) new TreeSet[9];
        for (int i = 1; i < 9; i++) {
            set[i] = new TreeSet<>();
        }
        
        int idx = 1;
        for (int i = 1; i < 9; i += 3) {
            for (int j = 1; j < 9; j += 3) {
                if (i == 4 && j == 4) continue;
                map.put(input[i][j], idx);
                for (int dir = 0; dir < 8; dir++) {
                    int r = i + dr[dir];
                    int c = j + dc[dir];
                    set[idx].add(input[r][c]);
                }
                idx++;
            }
        }
        
        int cntMap = 1;
        while (!map.isEmpty()) {
            var entry = map.pollFirstEntry();
            sb.append("#").append(cntMap).append(". ").append(entry.getKey()).append("\n");
            int cntSet = 1;
            while (!set[entry.getValue()].isEmpty()) {
                sb.append("#").append(cntMap).append("-").append(cntSet++).append(". ")
                  .append(set[entry.getValue()].pollFirst()).append("\n");
            }
            cntMap++;
        }
        System.out.print(sb);
    }
}