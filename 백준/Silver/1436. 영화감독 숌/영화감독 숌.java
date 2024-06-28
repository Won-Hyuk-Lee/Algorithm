import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n > 1) {
            findNthNumber(n);
        } else {
            System.out.println(666);
        }
    }
 
    public static void findNthNumber(int n) {
        int count = 1;  // 현재 숫자가 몇 번째인지
        int leadingDigits = 0; // 앞자릿수
        int trailingDigits = 0; // 앞자릿수를 제외한 나머지 뒷 자릿수

        while (true) {
 
            /*
             *  ?...666? 이면서 ?...6666 이 아닐 경우 
             *  끝자리가 6이 아닌케이스
             */
            if (((leadingDigits % 10000) / 10) == 666 && leadingDigits % 10 != 6) {
                for (int i = 0; i < 1000; i++) {
                    if (count == n) {
                        System.out.print(leadingDigits * 1000 + trailingDigits);
                        return;
                    }
                    trailingDigits++;
                    count++;
                }
                leadingDigits++;
            }
 
            // 앞자릿수가 ?...666
            else if (leadingDigits % 1000 == 666) {
                trailingDigits = 0;
                for (int i = 0; i < 1000; i++) {
                    if (count == n) {
                        System.out.print(leadingDigits * 1000 + trailingDigits);
                        return;
                    }
                    count++;
                    trailingDigits++;
                }
                leadingDigits++;
            }
 
            // 앞자릿수가 ?...66 일 경우
            else if (leadingDigits % 100 == 66) {
                trailingDigits = 600;
                for (int i = 0; i < 100; i++) {
                    if (count == n) {
                        System.out.print(leadingDigits * 1000 + trailingDigits);
                        return;
                    }
                    count++;
                    trailingDigits++;
                }
                leadingDigits++;
            }
 
            // 앞자릿수가 ?...6 일 경우
            else if (leadingDigits % 10 == 6) {
                trailingDigits = 660;
                for (int i = 0; i < 10; i++) {
                    if (count == n) {
                        System.out.print(leadingDigits * 1000 + trailingDigits);
                        return;
                    }
                    trailingDigits++;
                    count++;
                }
                leadingDigits++;
            } 
            
            // 그 외의 경우
            else {
                trailingDigits = 666;
                if (count == n) {
                    System.out.print(leadingDigits * 1000 + trailingDigits);
                    return;
                }
                count++;
                leadingDigits++;
            }
        }
    }
}
