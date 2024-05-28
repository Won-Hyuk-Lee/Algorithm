import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
        
		int xMin = Math.min(x, w-x);	// x가 작으면 x가 최소거리고 w-x가 x보다 작으면 최소거리
		int yMin = Math.min(y, h-y);	// 위와같음
        
		// x와 y축 최소거리 중 가장 작은 값 출력
		System.out.println(Math.min(xMin, yMin));
	}
 
}