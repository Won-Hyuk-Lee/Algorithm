import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] scores = {10, 8, 6, 5, 4, 3, 2, 1, 0};
        int[] times = new int[8];
        char[] teams = new char[8];
        
        for(int i = 0; i < 8; i++) {
            String testCase = sc.nextLine().trim();
            times[i] = Integer.parseInt(testCase.replaceAll("[^0-9]", ""));
            teams[i] = testCase.charAt(testCase.length() - 1);
        }
        
        sc.close();
        
        insertSort(times, teams, 0, 7);
        
        int totalRedScore = 0;
        int totalBlueScore = 0;

       for(int i = 0; i < 8; i++) {
            if(teams[i] == 'R') {
                totalRedScore += scores[i];
            } else {
                totalBlueScore += scores[i];
            }
        }

        if(totalBlueScore < totalRedScore) {
            System.out.println("Red");
        } else {
            System.out.println("Blue");
        }
    }
    
    private static void insertSort(int[] array1, char[] array2, int startIndex, int endIndex) {

        for(int maxIndex = (startIndex + 1); maxIndex <= endIndex; maxIndex++) {
            if(array1[maxIndex - 1] <= array1[maxIndex]) {
                continue;

            } else {
                insertion(array1, array2, startIndex, maxIndex);
            }
        }
    }

    private static void insertion(int[] array1, char[] array2, int startIndex, int insertIndex) {

        int insertionDestination = -1;
        for(int i = startIndex; i < insertIndex; i++) {
            if(array1[insertIndex] <= array1[i]) {
                insertionDestination = i;
                break;
            }
        }

        int temp1 = array1[insertIndex];
        for(int i = (insertIndex - 1); i >= insertionDestination; i--) {
            array1[i + 1] = array1[i];
        }
        array1[insertionDestination] = temp1;

        char temp2 = array2[insertIndex];
        for(int i = (insertIndex - 1); i >= insertionDestination; i--) {
            array2[i + 1] = array2[i];
        }
        array2[insertionDestination] = temp2;
    }
}