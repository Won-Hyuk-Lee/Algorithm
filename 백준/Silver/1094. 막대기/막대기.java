import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//입력받은 X가 0보다 클경우 N과 X를 비교한다
        //N(기본64의 스틱)이 더 클경우 N을 반으로 나눈다.
        //N이 X보다 작아질때까지 반복한다.
        //X가 N이상이 되면 하나의 길이를 만족하므로 빼고 카운트를 추가한다.
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = 64;
		int count = 0;
		
		while(x>0)
		{
			if(n>x)
			{
				n /= 2;
			}
			else
			{
				x -= n;
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
