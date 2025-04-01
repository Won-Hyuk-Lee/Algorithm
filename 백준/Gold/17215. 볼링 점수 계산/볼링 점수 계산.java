import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String record = br.readLine();
        
        int[] rolls = new int[21];
        int rollIndex = 0;
        int idx = 0;
        int frame = 1;
        boolean isFirstRoll = true;

        while (idx < record.length()) {
            char ch = record.charAt(idx++);
            if (ch == 'S') {
                rolls[rollIndex++] = 10;
                if (frame < 10) {
                    frame++;
                } else if (rollIndex == 19) {
                    frame++;
                }
                isFirstRoll = true;
            } else if (ch == 'P') {
                rolls[rollIndex] = 10 - rolls[rollIndex - 1];
                rollIndex++;
                if (frame < 10 || rollIndex == 20) {
                    frame++;
                }
                isFirstRoll = true;
            } else {
                rolls[rollIndex++] = (ch == '-') ? 0 : ch - '0';
                if (!isFirstRoll && frame < 10) {
                    frame++;
                }
                isFirstRoll = !isFirstRoll;
            }
        }

        int score = 0;
        int roll = 0;
        for (int currentFrame = 1; currentFrame <= 10; currentFrame++) {
            if (rolls[roll] == 10) {
                score += 10 + rolls[roll + 1] + rolls[roll + 2];
                roll++;
            } else if (rolls[roll] + rolls[roll + 1] == 10) {
                score += 10 + rolls[roll + 2];
                roll += 2;
            } else {
                score += rolls[roll] + rolls[roll + 1];
                roll += 2;
            }
        }

        System.out.println(score);
    }
}
