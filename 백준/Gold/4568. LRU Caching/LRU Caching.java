import java.util.*;

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int num = 0;
       LRUCache cache = new LRUCache();
       
       while (true) {
           String line = scanner.nextLine();
           if (line.equals("0")) break;
           
           num++;
           String[] fields = line.split("\\s+");
           int cacheSize = Integer.parseInt(fields[0]);
           String sequence = fields[1];
           
           cache.init(cacheSize);
           System.out.println("Simulation " + num);
           
           for (char c : sequence.toCharArray()) {
               if (c == '!') {
                   cache.print();
               } else {
                   cache.access(c);
               }
           }
       }
   }
   
   static class LRUCache {
       LinkedList<Character> cache = new LinkedList<>();
       HashMap<Character, Integer> map = new HashMap<>();
       int capacity;
       
       void init(int capacity) {
           cache.clear();
           map.clear();
           this.capacity = capacity;
       }
       
       void access(char c) {
           if (map.containsKey(c)) {
               cache.remove(map.get(c).intValue());
               cache.add(c);
               updateMap();
           } else {
               if (cache.size() == capacity) {
                   char removed = cache.removeFirst();
                   map.remove(removed);
               }
               cache.add(c);
               updateMap();
           }
       }
       
       void updateMap() {
           map.clear();
           for (int i = 0; i < cache.size(); i++) {
               map.put(cache.get(i), i);
           }
       }
       
       void print() {
           for (char c : cache) {
               System.out.print(c);
           }
           System.out.println();
       }
   }
}