import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int num = Integer.parseInt(br.readLine());
		
		int[] result = new int[10];
		
		for(int i = 1; i <= 10; i++) {
			result[i-1] = ((i - 1) % 5) + 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int count = 0;
			for(int j = 0; j < 10; j++) {
				if(Integer.parseInt(st.nextToken()) == result[j]) {
					count++;
				}
			}
			
			if(count == 10) {
				sb.append(i + 1).append("\n");
			}
		}
		System.out.print(sb);
	}
}