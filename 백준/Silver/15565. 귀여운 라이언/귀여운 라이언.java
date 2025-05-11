import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Integer> lionPositions = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                lionPositions.add(i);
            }
        }
        
        if (lionPositions.size() < K) {
            bw.write("-1");
        } else {
            int minSize = Integer.MAX_VALUE;
            for (int i = 0; i <= lionPositions.size() - K; i++) {
                minSize = Math.min(minSize, lionPositions.get(i + K - 1) - lionPositions.get(i) + 1);
            }
            bw.write(String.valueOf(minSize));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}