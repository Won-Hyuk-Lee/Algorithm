import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double r = sc.nextDouble(); //float으로 하면 계산이 조금 틀림
		sc.close();
		System.out.println(String.format("%.6f", Math.PI * r * r)); //유클리드 기하학
		System.out.println(String.format("%.6f", 2 * r * r)); //택시 기하학
	}

}