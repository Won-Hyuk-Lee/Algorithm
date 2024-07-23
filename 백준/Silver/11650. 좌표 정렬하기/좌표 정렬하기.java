import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String args[]) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int num = Integer.parseInt(br.readLine());
	    
	    int[][] arr = new int[num][2];

	    for(int i = 0; i < num; i++) {
	        String[] str = br.readLine().split(" ");
	        arr[i][0] = Integer.parseInt(str[0]);
	        arr[i][1] = Integer.parseInt(str[1]);
	    }
	    
        //정렬
	    Arrays.sort(arr, (e1, e2) -> {
	        if(e1[0] == e2[0]) {
	            return e1[1] - e2[1]; //첫 번째 값이 같으면 두 번째 값 비교
	        } else {
	            return e1[0] - e2[0]; //첫 번째 값으로 비교
	        }
	    });
	    
	    for(int i = 0; i < num; i++) {
	        System.out.println(arr[i][0] + " " + arr[i][1]);
	    }
	}
}
