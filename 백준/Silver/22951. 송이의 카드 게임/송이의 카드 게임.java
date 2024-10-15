import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int numOfPeople = Integer.parseInt(inputs[0]);
        int numOfCard = Integer.parseInt(inputs[1]);
        int[] cardArray = new int[numOfPeople*numOfCard];

        int index = 0;
        for (int peopleNo = 0; peopleNo < numOfPeople; peopleNo++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int cardNo = peopleNo*numOfCard; cardNo < peopleNo*numOfCard+numOfCard; cardNo++) {
                int number = Integer.parseInt(st.nextToken());
                cardArray[index++] = number;
            }
        }

        index = 0;
        int sumOfCard = numOfPeople*numOfCard;
        while (sumOfCard-- > 1) {
            int interval = cardArray[index];
            cardArray[index] = 0;
            while (interval > 0) {
                if (++index > cardArray.length-1) {
                    index = 0;
                }
                if (cardArray[index] != 0) {
                    interval--;
                }
            }
        }

        int lastCardIndex = 0;
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i] != 0) {
                lastCardIndex = i;
                break;
            }
        }

        int winnerNo = (lastCardIndex)/numOfCard + 1;
        int lastCardNo = cardArray[lastCardIndex];

        System.out.println(winnerNo+" "+lastCardNo);
    }
}