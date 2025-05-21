import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int forum, num;
		int sum = 0;
		
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			forum = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if (forum == 1) {
				sum += num;
			} else {
				if (sum < num) {
					sb.append("Adios");
				} else {
					sum -= num;
				}
			}
			
			if (sb.length() > 0) {
				break;
			}
		}
		
		if (sb.length() == 0) {
			sb.append("See you next month");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}