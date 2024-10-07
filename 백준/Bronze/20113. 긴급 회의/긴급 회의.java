import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] players = new int[size+1];
		for(int i=0;i<size;i++) {
			int tmp = sc.nextInt();
			players[tmp]++;
		}
		int max = 0;
		int idx = 0;
		for(int i=1;i<=size;i++)
			if(players[i]>max) {
				max = players[i];
				idx = i;
			}
		for(int i=1;i<=size;i++)
			if(idx!=i && players[i]==max) {
				System.out.println("skipped");
				return;
			}
		System.out.println(idx);
	}
}