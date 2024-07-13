import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputs = new int[8];

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = sc.nextInt();
        }
        sc.close();

        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < inputs.length - 1; i++) {
            if (inputs[i] < inputs[i + 1]) {
                isDescending = false; //오름차순일 경우
            } else if (inputs[i] > inputs[i + 1]) {
                isAscending = false; //내림차순일 경우
            }
        }

        if (isAscending) {
            System.out.println("ascending");
        } else if (isDescending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
