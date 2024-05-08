import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt(); // 주어지는숫자N
		int b = sc.nextInt(); // N의 약수중 b번째로 작은수를 출력해야함
		ArrayList<Integer> divisorList = new ArrayList<>();
		
		for (int i = 1;i<a+1;i++)
		{
			if(a%i==0) 
			{
				divisorList.add(i);
			}
			
			
		}
		if(divisorList.size() < b) System.out.println(0);
		else System.out.println(divisorList.get(b-1));


	}
}
