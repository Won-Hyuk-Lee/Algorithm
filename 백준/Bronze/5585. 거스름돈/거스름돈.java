import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int changes = 1000;
		int price = sc.nextInt();
		int count = 0;
		
		changes -=price;
		int[] value = {500, 100, 50, 10, 5, 1};
		int n = 0;
		
		while(changes != 0)
		{
			if(value[n]>changes)
			{
				n++;
			}
			else
			{
				changes-= value[n];
				count++;
			}
		}
		System.out.println(count);

	}

}
