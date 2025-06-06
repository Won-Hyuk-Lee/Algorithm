import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(input[i]);
        }
        
        int[] maxVal = new int[n];
        int[] maxPos = new int[n];
        int[] minVal = new int[n];
        int[] minPos = new int[n];
        
        int maxV = -1, minV = 987654321;
        int maxP = -1, minP = -1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (maxV <= v[i]) {
                maxV = v[i];
                maxP = i;
            }
            if (minV >= v[i]) {
                minV = v[i];
                minP = i;
            }
            maxVal[i] = maxV;
            maxPos[i] = maxP;
            minVal[i] = minV;
            minPos[i] = minP;
        }
        
        int answer = 987654321;
        int tmp = -1;
        
        for (int i = 0; i < n; i++) {
            if (maxVal[i] - minVal[i] >= tmp) {
                tmp = maxVal[i] - minVal[i];
                answer = Math.min(answer, Math.abs(maxPos[i] - minPos[i]));
            }
        }
        
        System.out.println(answer + 1);
    }
}