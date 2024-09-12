import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main (String[] args) throws java.lang.Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt =0 ;
		while(true){
		    cnt = 0;
		    String str = br.readLine().toUpperCase();
		    if(str.equals("#")){
		        break;
		    }
		    cnt += str.chars().filter(c -> (c == 'I' || c == 'O' || c == 'A' || c == 'U' || c == 'E') ).count();
		   	System.out.println(cnt);
		}
	}
}