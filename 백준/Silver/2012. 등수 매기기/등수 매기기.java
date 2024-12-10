import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		arr[0] = 0;
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long disappointment = 0;
		for (int i= 1; i<=N; i++) { 
			disappointment += Math.abs(i-arr[i]); 
		}
		System.out.println(disappointment);
	}

}