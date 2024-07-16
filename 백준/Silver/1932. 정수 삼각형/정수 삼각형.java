import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int d[][] = new int[n+1][n+1]; //dp배열
		
		//삼각형 최댓값
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (j == 1) {
					//1열은 왼쪽 대각선 값이x 바로 위의 값만+
					d[i][j] = d[i-1][j] + value;
				} else if (j == i) {
					//마지막열은 오른쪽 대각선 값x 왼쪽 대각선 값만++
					d[i][j] = d[i-1][j-1] + value;
				} else {
					//가운데 값들은 둘중 큰 값++
					d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + value;
				}
			}
		}
		
		//마지막 층에서 최댓값을 찾기
		int ans = 0;
		for(int i=1; i<=n; i++) {
			if(ans < d[n][i]) ans = d[n][i]; 
		}
		
		System.out.println(ans);
	}
}
