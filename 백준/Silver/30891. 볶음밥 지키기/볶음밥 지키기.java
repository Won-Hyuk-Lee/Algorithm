import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = read(), r = read();
        
        int[][] points = new int[n][2];
        int minCoord = Integer.MAX_VALUE;
        int maxCoord = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            points[i][0] = read();
            points[i][1] = read();
            minCoord = Math.min(minCoord, points[i][0]);
            maxCoord = Math.max(maxCoord, points[i][0]);
            minCoord = Math.min(minCoord, points[i][1]);
            maxCoord = Math.max(maxCoord, points[i][1]);
        }
        
        int maxCount = 0;
        int resultY = 0, resultX = 0;
        double rSquared = (double) r * r;
        
        for (int i = minCoord; i <= maxCoord; i++) {
            for (int j = minCoord; j <= maxCoord; j++) {
                int count = 0;
                for (int[] point : points) {
                    double distSquared = Math.pow(i - point[0], 2) + Math.pow(j - point[1], 2);
                    if (distSquared <= rSquared) {
                        count++;
                    }
                }
                
                if (count > maxCount) {
                    maxCount = count;
                    resultY = i;
                    resultX = j;
                }
            }
        }
        
        bw.write(resultY + " " + resultX);
        bw.flush();
        bw.close();
    }
    
    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        
        if (isNegative) n = System.in.read() & 15;
        
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        
        return isNegative ? -n : n;
    }
}