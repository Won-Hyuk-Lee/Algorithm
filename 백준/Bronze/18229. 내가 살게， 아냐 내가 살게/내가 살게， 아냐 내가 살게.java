import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sc.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(sc.readLine());
            for(int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] people = new int[N + 1];
        L: for(int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {
                people[i + 1] += array[i][j];
                
                if(people[i + 1] >= K) {
                    sb.append(i + 1).append(" ").append(j + 1);
                    break L;
                }
            }
        } 
        System.out.println(sb);
    }
}
