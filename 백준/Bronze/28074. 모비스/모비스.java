import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        Set<Character> chars = new HashSet<>();
        for (char c : input.toCharArray()) {
            chars.add(c);
        }
        
        if (chars.containsAll(Set.of('M', 'O', 'B', 'I', 'S'))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        sc.close();
    }
}