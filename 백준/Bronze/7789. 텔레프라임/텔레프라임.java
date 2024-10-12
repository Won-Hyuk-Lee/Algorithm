import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken() + String.valueOf(A));
		int i = 2;
		String S = "";
		
		while(true) {
			if(i < A && A % i == 0) {
				S = "No";
				break;
			}
			if(i < B && B % i == 0) {
				S = "No";
				break;
			}
			
			i++;
			if(i == B) {
				S = "Yes";
				break;
			}
		}
		System.out.println(S);
	}

}