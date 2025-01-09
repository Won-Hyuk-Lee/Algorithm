import java.util.*;

public class Main {
    static class Participant {
        int score;
        int attempts;
        int lastUploadTime;
        int id;

        Participant(int score, int attempts, int lastUploadTime, int id) {
            this.score = score;
            this.attempts = attempts;
            this.lastUploadTime = lastUploadTime;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfParticipants = scanner.nextInt();
        List<Participant> participants = new ArrayList<>();

        for (int i = 0; i < numberOfParticipants; i++) {
            int score = scanner.nextInt();
            int attempts = scanner.nextInt();
            int lastUploadTime = scanner.nextInt();
            participants.add(new Participant(score, attempts, lastUploadTime, i + 1));
        }

        participants.sort((p1, p2) -> {
            if (p1.score != p2.score) {
                return Integer.compare(p2.score, p1.score);
            } else if (p1.attempts != p2.attempts) {
                return Integer.compare(p1.attempts, p2.attempts);
            } else {
                return Integer.compare(p1.lastUploadTime, p2.lastUploadTime);
            }
        });

        System.out.println(participants.get(0).id);
    }
}
