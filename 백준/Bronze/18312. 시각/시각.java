import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
	public static int N, K;
	public static int result = 0;
	public static int x, y;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	simulate();
    	System.out.println(result);
    }
    
    public static void simulate() {
    	for(int hour = 0; hour <= N; hour ++) {
    		for(int minute = 0; minute < 60; minute++) {
    			for(int second = 0; second < 60; second ++) {
    				if( hour % 10 == K || hour / 10 == K || minute % 10 == K || minute / 10 == K || second % 10 == K || second / 10 == K ) {
    					result += 1;
    				}
    			}
    		}
    	}
    }
    
    
}