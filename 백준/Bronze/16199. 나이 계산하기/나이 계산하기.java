import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int year1 = sc.nextInt(), month1 = sc.nextInt(), day1 = sc.nextInt();
        int year2 = sc.nextInt(), month2 = sc.nextInt(), day2 = sc.nextInt();
        int age1 = 0;
        
        if(month1<month2){
            age1 = year2 - year1;
        }else if(month1 == month2 && day1 <= day2){
            age1 = year2 - year1;
        }else{
            age1 = year2 - year1 - 1;
        }
        int age2 = year2-year1+1;
        int age3 = year2-year1;
        
        System.out.println(age1);
        System.out.println(age2);
        System.out.println(age3);
    }
} //손코딩 결과는?