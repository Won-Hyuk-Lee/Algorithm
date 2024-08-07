import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			
			for(int j = 0; j < a.length() - 1; j++) {
				if(a.charAt(j) == '0' && a.charAt(j + 1) == '1' || a.charAt(j) == 'O' && a.charAt(j + 1) == 'I') {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}