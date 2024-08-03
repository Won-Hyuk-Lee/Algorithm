import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int numTrees = scanner.nextInt(); //나무개수
        int requiredWood = scanner.nextInt(); //필요한나무길이
        
        int[] treeHeights = new int[numTrees]; //나무높이
        
        int minHeight = 0; //최소높
        int maxHeight = 0; //최대높
        
        for(int i = 0; i < numTrees; i++) {
            treeHeights[i] = scanner.nextInt();
            //나무의 최대 높이 갱신
            if(maxHeight < treeHeights[i]) {
                maxHeight = treeHeights[i];
            }
        }
        
        //자를 높이 결정
        while(minHeight < maxHeight) {
            int midHeight = (minHeight + maxHeight) / 2;
            long totalWood = 0;
            //자른 나무의 총 길이
            for(int height : treeHeights) {
                if(height > midHeight) {
                    totalWood += (height - midHeight);
                }
            }
            
            //필요한 길이보다 작으면 자르는 높이 낮춤
            if(totalWood < requiredWood) {
                maxHeight = midHeight;
            } 
            //필요한 길이보다 크거나 같으면 자르는 높이 높임
            else {
                minHeight = midHeight + 1;
            }
        }
        System.out.println(minHeight - 1);
    }
}
