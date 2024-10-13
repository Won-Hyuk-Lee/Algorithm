import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int w = Integer.parseInt(br.readLine()); //가로
		int h = Integer.parseInt(br.readLine()); //세로
		
		int result = 0;
		if (w == 1 || h == 1) {
			result = 0;
		} else { 
			result = 2 * (h - 1) * (w - 1);
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}