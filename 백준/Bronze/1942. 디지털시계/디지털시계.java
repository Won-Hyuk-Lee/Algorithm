import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String[] times = br.readLine().split(" ");
            int startTimeSeconds = toTimeSeconds(times[0]);
            int endTimeSeconds = toTimeSeconds(times[1]);

            if (startTimeSeconds > endTimeSeconds) {
                endTimeSeconds += 24 * 3600;
            }

            int count = 0;
            for (int currentTime = startTimeSeconds; currentTime <= endTimeSeconds; currentTime++) {
                if (transformTimeToLiteralNumber(currentTime % (24 * 3600)) % 3 == 0) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static int transformTimeToLiteralNumber(int timeSeconds) {
        int hours = timeSeconds / 3600;
        int minutes = (timeSeconds % 3600) / 60;
        int seconds = timeSeconds % 60;
        return hours * 10000 + minutes * 100 + seconds;
    }

    private static int toTimeSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
}
