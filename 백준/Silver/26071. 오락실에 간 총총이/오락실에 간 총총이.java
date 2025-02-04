import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minX = 1501, maxX = -1, minY = 1501, maxY = -1;
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'G') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        if (minX == maxX && minY == maxY) {
            System.out.println(0);
        } else if (minX == maxX) {
            System.out.println(Math.min(maxY, N - minY - 1));
        } else if (minY == maxY) {
            System.out.println(Math.min(maxX, N - minX - 1));
        } else {
            System.out.println(Math.min(maxX, N - minX - 1) + Math.min(maxY, N - minY - 1));
        }
    }
}