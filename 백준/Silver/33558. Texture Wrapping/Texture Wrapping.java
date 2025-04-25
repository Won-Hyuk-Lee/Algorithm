import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = br.readLine().split(" ");
        int u = Integer.parseInt(secondLine[0]);
        int v = Integer.parseInt(secondLine[1]);
        
        char[][] texture = new char[u][v];
        for (int i = 0; i < u; i++) {
            String line = br.readLine();
            for (int j = 0; j < v; j++) {
                texture[i][j] = line.charAt(j);
            }
        }
        
        String method = br.readLine();
        char[][] result = new char[n][m];
        
        if (method.equals("clamp-to-edge")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result[i][j] = texture[Math.min(i, u - 1)][Math.min(j, v - 1)];
                }
            }
        } else if (method.equals("repeat")) {
            for (int i = 0; i < n; i++) {
                int idxRow = i % u;
                for (int j = 0; j < m; j++) {
                    result[i][j] = texture[idxRow][j % v];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                int tileRow = i / u;
                int posRow = i % u;
                int realRow = (tileRow % 2 == 0) ? posRow : (u - 1 - posRow);
                
                for (int j = 0; j < m; j++) {
                    int tileCol = j / v;
                    int posCol = j % v;
                    int realCol = (tileCol % 2 == 0) ? posCol : (v - 1 - posCol);
                    
                    result[i][j] = texture[realRow][realCol];
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(result[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}