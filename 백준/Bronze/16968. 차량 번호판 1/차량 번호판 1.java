import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.next().split("");

		int total = s[0].equals("c") ? 26 : 10;
		String prev = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i].equals("c")) {
				if (s[i].equals(prev)) total *= 25;  
				else total *= 26;  
			}
			else if (s[i].equals("d")) {  
				if (s[i].equals(prev)) total *= 9;  
				else total *= 10; 
			}
			
			prev = s[i];
		}
		
		System.out.println(total);
		
		sc.close();
	}
}