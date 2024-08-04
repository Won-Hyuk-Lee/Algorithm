import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        System.out.println(fact(inputNum));
    }

    static long fact(int n){
        long result = 1;
        for(long i = n;i>1;i--){
            result *= i;
        }
        return result;
    }
}
