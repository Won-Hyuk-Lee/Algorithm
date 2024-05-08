import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		
		for(int i =0; i<testCase;i++)
		{
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println(num1 * num2 / GCD(num1,num2)); //두수의곱/최대공약수 = 최소공배수
		}

	}

	public static long GCD(long num1, long num2) // 최대공약수
	{
		if (num1 % num2 == 0)
			return num2;
		return GCD(num2, num1 % num2);
	}
}
