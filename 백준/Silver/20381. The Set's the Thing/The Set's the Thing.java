import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            List<String> cards = new ArrayList<>();
            String line;
            
            while (sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
                cards.add(line);
            }
            
            if (cards.isEmpty()) break;
            
            System.out.print("CARDS:  ");
            for (int i = 0; i < cards.size(); i++) {
                System.out.print(cards.get(i));
                if (i < cards.size() - 1) System.out.print(" ");
            }
            System.out.println();
            
            List<List<Integer>> sets = findSets(cards);
            
            if (sets.isEmpty()) {
                System.out.println("SETS:   *** None Found ***");
            } else {
                for (int i = 0; i < sets.size(); i++) {
                    if (i == 0) {
                        System.out.printf("SETS:   %d.  ", i + 1);
                    } else {
                        System.out.printf("        %d.  ", i + 1);
                    }
                    for (int j = 0; j < sets.get(i).size(); j++) {
                        System.out.print(cards.get(sets.get(i).get(j)));
                        if (j < sets.get(i).size() - 1) System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
    
    static List<List<Integer>> findSets(List<String> cards) {
        List<List<Integer>> sets = new ArrayList<>();
        
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    if (isSet(cards.get(i), cards.get(j), cards.get(k))) {
                        sets.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }
        
        return sets;
    }
    
    static boolean isSet(String card1, String card2, String card3) {
        for (int i = 0; i < 4; i++) {
            char c1 = card1.charAt(i);
            char c2 = card2.charAt(i);
            char c3 = card3.charAt(i);
            
            if (!((c1 == c2 && c2 == c3) || (c1 != c2 && c2 != c3 && c1 != c3))) {
                return false;
            }
        }
        return true;
    }
}