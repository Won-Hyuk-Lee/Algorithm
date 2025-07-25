import java.util.*;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       sc.nextLine();
       
       for (int i = 0; i < t; i++) {
           String line = sc.nextLine();
           String[] parts = line.split("\\+|=");
           String roman1 = parts[0];
           String roman2 = parts[1];
           
           int num1 = romanToInt(roman1);
           int num2 = romanToInt(roman2);
           int sum = num1 + num2;
           
           System.out.print(line);
           if (sum > 1000) {
               System.out.println("CONCORDIA CUM VERITATE");
           } else {
               System.out.println(intToRoman(sum));
           }
           
           if (i < t - 1) {
               System.out.println();
           }
       }
   }
   
   static int romanToInt(String s) {
       Map<Character, Integer> map = new HashMap<>();
       map.put('I', 1);
       map.put('V', 5);
       map.put('X', 10);
       map.put('L', 50);
       map.put('C', 100);
       map.put('D', 500);
       map.put('M', 1000);
       
       int result = 0;
       for (int i = 0; i < s.length(); i++) {
           int current = map.get(s.charAt(i));
           if (i + 1 < s.length() && current < map.get(s.charAt(i + 1))) {
               result -= current;
           } else {
               result += current;
           }
       }
       return result;
   }
   
   static String intToRoman(int num) {
       int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
       String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
       
       StringBuilder result = new StringBuilder();
       for (int i = 0; i < values.length; i++) {
           while (num >= values[i]) {
               result.append(symbols[i]);
               num -= values[i];
           }
       }
       return result.toString();
   }
}