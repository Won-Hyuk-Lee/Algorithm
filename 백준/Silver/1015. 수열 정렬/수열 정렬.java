import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }
        
        Arrays.sort(B);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            indexMap.putIfAbsent(B[i], i);
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(indexMap.get(A[i])).append(" ");
            indexMap.put(A[i], indexMap.get(A[i]) + 1);
        }
        
        System.out.println(sb);
    }
}