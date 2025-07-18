import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N, K, P, X, result;
    static int[][] cost;
    static int[] currentFloor;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);
        
        cost = new int[][]{
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
        };
        
        currentFloor = new int[K];
        int temp = X;
        for (int i = K - 1; i >= 0; i--) {
            currentFloor[i] = temp % 10;
            temp /= 10;
        }
        
        dfs(0, 0, 0);
        System.out.println(result - 1);
    }
    
    static void dfs(int pos, int num, int usedCost) {
        if (usedCost > P) return;
        
        if (pos == K) {
            if (num > 0 && num <= N) result++;
            return;
        }
        
        for (int digit = 0; digit < 10; digit++) {
            int newCost = usedCost + cost[currentFloor[pos]][digit];
            if (newCost <= P) {
                dfs(pos + 1, num * 10 + digit, newCost);
            }
        }
    }
}