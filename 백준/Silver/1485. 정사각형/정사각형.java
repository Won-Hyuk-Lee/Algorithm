import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스
        
        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            Point[] points = new Point[4]; // 4개의 점을 저장할 배열
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Point(x, y); // 입력받은 좌표로 Point 객체 생성
            }
            
            double[] len = new double[6]; // 점들 간의 거리 배열
            int count = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    len[count++] = calculateDistance(points[j], points[k]); // 점 거리 계산
                }
            }

            Arrays.sort(len); // 거리 배열 정렬
            // 정사각형 확인
            boolean isSquare = len[0] == len[1] && len[1] == len[2] && len[2] == len[3] && len[4] == len[5];

            bw.write((isSquare ? 1 : 0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 두 점 사이의 거리 계산
    static double calculateDistance(Point point1, Point point2) {
        int dx = point1.x - point2.x;
        int dy = point1.y - point2.y;
        return dx * dx + dy * dy; 
    }
}

// 좌표를 저장 클래스
class Point {
    int x; 
    int y;
    
    public Point(int x, int y) {
        this.x = x; 
        this.y = y;
    }
}
