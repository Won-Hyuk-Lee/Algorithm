import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxMatch = findMaxMatches(arr, n, k);
        System.out.println(n - maxMatch);
    }
    
    private int findMaxMatches(int[] arr, int n, int k) {
        int maxCount = 0;
        
        for (int start = 1; start <= 1000; start++) {
            int count = 0;
            int expectedValue = start;
            
            for (int j = 0; j < n; j++) {
                if (arr[j] == expectedValue) {
                    count++;
                }
                expectedValue += k;
            }
            
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}