import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int result;
        
        if (input.startsWith("0x")) {
            result = Integer.parseInt(input.substring(2), 16);
        } else if (input.startsWith("0") && input.length() > 1) {
            result = Integer.parseInt(input.substring(1), 8);
        } else {
            result = Integer.parseInt(input);
        }
        
        System.out.println(result);
        sc.close();
    }
}