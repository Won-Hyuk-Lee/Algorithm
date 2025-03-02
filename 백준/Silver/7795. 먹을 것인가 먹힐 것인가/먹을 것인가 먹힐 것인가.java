import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(B);
            int temp = 0;
            
            for (int i = 0; i < N; i++) {
                int low = 0, high = M - 1, cnt = 0;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (B[mid] < A[i]) {
                        low = mid + 1;
                        cnt = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                temp += cnt;
            }
            result.append(temp).append("\n");
        }
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}