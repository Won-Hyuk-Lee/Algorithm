import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t,n,m,s,i;
		t = Integer.parseInt(br.readLine());
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			int[] arr = new int[1001];
			while(n-->0) arr[Integer.parseInt(br.readLine())]++;
			s = m = 0;
			for(i=1;i<1001;i++) if(arr[i]>m) {
				m = arr[i];
				s = i;
			}
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}
}