import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int inventory = Integer.parseInt(st.nextToken());
        
        //최소,최대높이
        int[][] terrain = new int[rows][cols];
        int minHeight = 256;
        int maxHeight = 0;
        
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                terrain[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, terrain[i][j]);
                maxHeight = Math.max(maxHeight, terrain[i][j]);
            }
        }
        
        int minTime = Integer.MAX_VALUE;
        int optimalHeight = 0;
        
        //각 높이 시간 계산
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int removeCount = 0;
            int addCount = 0;
            int tempInventory = inventory;
            
            //각 블록 작업 계산
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int diff = terrain[i][j] - targetHeight;
                    if (diff > 0) {
                        removeCount += diff;
                        tempInventory += diff;
                    } else if (diff < 0) {
                        addCount -= diff;
                        tempInventory += diff;
                    }
                }
            }
            
            //작업 가능한 경우만
            if (tempInventory >= 0) {
                int time = removeCount * 2 + addCount;
                if (time <= minTime) {
                    minTime = time;
                    optimalHeight = targetHeight;
                }
            }
        }
        System.out.println(minTime + " " + optimalHeight);
    }
}