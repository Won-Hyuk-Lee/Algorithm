import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] time = sc.nextLine().split(" ");

        int year = Integer.parseInt(time[2]);
        boolean isLeapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));

        String month = time[0];
        int monthIndex = switch (month) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            case "June" -> 6;
            case "July" -> 7;
            case "August" -> 8;
            case "September" -> 9;
            case "October" -> 10;
            case "November" -> 11;
            case "December" -> 12;
            default -> 0;
        };

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Integer.parseInt(time[1].split(",")[0]);
        int cumulativeDays = 0;

        for (int i = 1; i < monthIndex; i++) {
            cumulativeDays += (isLeapYear && i == 2) ? 29 : daysInMonth[i];
        }
        cumulativeDays += day;

        int hour = Integer.parseInt(time[3].split(":")[0]);
        int minute = Integer.parseInt(time[3].split(":")[1]);
        int totalMinutes = (cumulativeDays - 1) * 1440 + hour * 60 + minute;

        int totalYearMinutes = isLeapYear ? 366 * 1440 : 365 * 1440;

        System.out.println((double) totalMinutes * 100 / totalYearMinutes);
    }
}