import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		 
		int n = sc.nextInt(); //나올 화폐의 갯수
		int k = sc.nextInt(); //맞출 가치
		int [] value = new int[n];
		int count = 0; //필요한 최소동전의 갯수
		for(int i = 0;i<n;i++)
		{
			value[i] = sc.nextInt();
		}
		
		//입력받기 완료
		
		//구현부
		
		while(k != 0)
		{
			if(value[n-1]>k)
			{
				n--;
			}
			else
			{
				k-= value[n-1];
				count++;
			}
		}
		System.out.println(count);

		
	}

}
