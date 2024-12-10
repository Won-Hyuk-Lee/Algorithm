import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int page = 1; 
		int min = arr[0]; 
		
		for (int i = 1; i < n; i++) {
			
			if (min * 2 <= arr[i]) { 
				page++; 
				min = arr[i]; 
			}
		}
		
		bw.write(Integer.toString(page));
		bw.flush();
		bw.close();
		br.close();
	}
}