import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int q = Integer.parseInt(st.nextToken()); 
		
		boolean[] visit = new boolean[n + 1]; 
		int count = n; 
		
		int number, x;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			number = Integer.parseInt(st.nextToken());
			
			switch (number) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				
				if (!visit[x]) { 
					count--;
				}
				
				visit[x] = true; 
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				
				if (visit[x]) { 
					count++;
				}
				
				visit[x] = false; 
				break;
			case 3: 
				sb.append(count).append("\n");
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}