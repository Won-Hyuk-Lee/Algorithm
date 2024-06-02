import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder(str);
			String strReverse = sb.reverse().toString();
			
			if(str.equals("0")) break;
			
			if(str.equals(strReverse)) {
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}

}