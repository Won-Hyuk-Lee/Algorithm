import java.io.*;
import java.util.*;

public class Main {
    static class Train {
        String number;
        int departTime;
        
        Train(String number, int departTime) {
            this.number = number;
            this.departTime = departTime;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        
        ArrayList<ArrayList<Integer>> trainTimes = new ArrayList<>();
        ArrayList<String> trainNumbers = new ArrayList<>();
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            trainNumbers.add(number);
            
            ArrayList<Integer> times = new ArrayList<>();
            int time;
            while ((time = Integer.parseInt(st.nextToken())) != -1) {
                times.add(time);
            }
            trainTimes.add(times);
        }
        
        long currentTime = M;
        String lastTrain = "";
        
        if (N <= 60) {
            for (long i = 0; i < N; i++) {
                int nextDepartTime = Integer.MAX_VALUE;
                int trainIndex = -1;
                
                for (int j = 0; j < T; j++) {
                    int departTime = getNextDepartureTime(trainTimes.get(j), (int)(currentTime % 60));
                    if (departTime < nextDepartTime) {
                        nextDepartTime = departTime;
                        trainIndex = j;
                    }
                }
                
                lastTrain = trainNumbers.get(trainIndex);
                currentTime = nextDepartTime + 1;
            }
            System.out.println(lastTrain);
            return;
        }
        
        HashMap<Integer, Long> timeToStation = new HashMap<>();
        HashMap<Integer, String> timeToTrain = new HashMap<>();
        
        for (long station = 0; station < N; station++) {
            int timeKey = (int)(currentTime % 60);
            
            if (timeToStation.containsKey(timeKey)) {
                long cycleStart = timeToStation.get(timeKey);
                long cycleLength = station - cycleStart;
                
                long remaining = N - station;
                long jumps = remaining / cycleLength;
                long extra = remaining % cycleLength;
                
                if (extra == 0) {
                    lastTrain = timeToTrain.get(timeKey);
                } else {
                    station += jumps * cycleLength;
                    
                    for (long i = 0; i < extra; i++) {
                        int nextDepartTime = Integer.MAX_VALUE;
                        int trainIndex = -1;
                        
                        for (int j = 0; j < T; j++) {
                            int departTime = getNextDepartureTime(trainTimes.get(j), (int)(currentTime % 60));
                            if (departTime < nextDepartTime) {
                                nextDepartTime = departTime;
                                trainIndex = j;
                            }
                        }
                        
                        lastTrain = trainNumbers.get(trainIndex);
                        currentTime = nextDepartTime + 1;
                    }
                }
                
                break;
            }
            
            timeToStation.put(timeKey, station);
            
            int nextDepartTime = Integer.MAX_VALUE;
            int trainIndex = -1;
            
            for (int j = 0; j < T; j++) {
                int departTime = getNextDepartureTime(trainTimes.get(j), (int)(currentTime % 60));
                if (departTime < nextDepartTime) {
                    nextDepartTime = departTime;
                    trainIndex = j;
                }
            }
            
            lastTrain = trainNumbers.get(trainIndex);
            timeToTrain.put(timeKey, lastTrain);
            currentTime = nextDepartTime + 1;
        }
        
        System.out.println(lastTrain);
    }
    
    static int getNextDepartureTime(ArrayList<Integer> times, int currentTime) {
        int min = Integer.MAX_VALUE;
        
        for (int time : times) {
            if (time >= currentTime && time < min) {
                min = time;
            }
        }
        
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        
        for (int time : times) {
            if (time + 60 >= currentTime && time + 60 < min) {
                min = time + 60;
            }
        }
        
        return min;
    }
}