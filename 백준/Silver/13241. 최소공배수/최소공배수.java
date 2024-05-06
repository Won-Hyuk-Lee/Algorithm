import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		long num1 = sc.nextInt(); //int형으로 했더니 계속 틀려서 확인해보니 숫자의 범위가...
		long num2 = sc.nextInt();
		System.out.println(num1 * num2 / GCD(num1, num2)); // 최소공배수 = 두수의곱/최대공약수

	}

	public static long GCD(long num1, long num2) // 최대공약수
	{
		if (num1 % num2 == 0)
			return num2;
		return GCD(num2, num1 % num2);
	}

}
