import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var arr = new int[N];
        
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < Math.min(i + 100, N); j++) {
                int diff = arr[j] - arr[i];
                if (diff % 2 == 0) {
                    minEven = Math.min(minEven, diff);
                    if (minEven == 2) break;
                } else {
                    minOdd = Math.min(minOdd, diff);
                    if (minOdd == 1) break;
                }
                
                if (minEven == 2 && minOdd == 1) break;
            }
            
            if (minEven == 2 && minOdd == 1) break;
        }
        
        System.out.print((minEven == Integer.MAX_VALUE ? -1 : minEven) + " " + 
                        (minOdd == Integer.MAX_VALUE ? -1 : minOdd));
    }
}