import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 면적당 참외 개수
        int hMax = 0, wMax = 0; // 각 가로 세로의 최대 길이 저장
        int hMaxIdx = -1, wMaxIdx = -1; // 가로 세로의 최대 길이 저장
        int[] dirs = new int[6]; // 순서대로 방향 저장
        int[] dist = new int[6]; // 변의 길이 저장
        
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dirs[i] = Integer.parseInt(st.nextToken()); // 방향 저장
            dist[i] = Integer.parseInt(st.nextToken()); // 길이 저장
            if (dirs[i] == 1 || dirs[i] == 2) { // 가로 방향이면
                if (hMax < dist[i]) { // 가로 최대 길이 갱신
                    hMax = dist[i];
                    hMaxIdx = i;
                }
            } else { // 세로 방향이면
                if (wMax < dist[i]) { // 세로 최대 길이 갱신
                    wMax = dist[i];
                    wMaxIdx = i;
                }
            }
        }
        
        int maxSquare = wMax * hMax; // 전체 큰 사각형의 넓이
        int minSquare = dist[(wMaxIdx + 3) % 6] * dist[(hMaxIdx + 3) % 6]; // 내부 작은 사각형의 넓이
        
        System.out.println((maxSquare - minSquare) * K);
    }
}
