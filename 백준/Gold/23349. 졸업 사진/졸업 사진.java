import java.io.*;
import java.util.*;

public class Main {    
    static int N;
    
    static class PlaceTime implements Comparable<PlaceTime> {
        String place;
        int start;
        
        public PlaceTime(String place, int start) {
            this.place = place;
            this.start = start;
        }
        
        @Override
        public int compareTo(PlaceTime pt) {
            if(!this.place.equals(pt.place)) {
                return this.place.compareTo(pt.place);
            }
            return Integer.compare(this.start, pt.start);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        HashMap<String, TreeMap<Integer, Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        int max = -1;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            if(set.contains(name))
                continue;
            set.add(name);
            
            TreeMap<Integer, Integer> timeSlots = map.computeIfAbsent(place, k -> new TreeMap<>());
            for(int time = start; time < end; time++) {
                timeSlots.put(time, timeSlots.getOrDefault(time, 0) + 1);
                max = Math.max(max, timeSlots.get(time));
            }
        }
        
        List<PlaceTime> maxVisitPlaces = new ArrayList<>();
        for(String place : map.keySet()) {
            TreeMap<Integer, Integer> timeSlots = map.get(place);
            for(Map.Entry<Integer, Integer> timeEntry : timeSlots.entrySet()) {
                int time = timeEntry.getKey();
                if(timeEntry.getValue() == max) {
                    maxVisitPlaces.add(new PlaceTime(place, time));
                    break;
                }
            }
        }
        
        Collections.sort(maxVisitPlaces);
        
        PlaceTime bestTime = maxVisitPlaces.get(0);
        int endTime = findEnd(map.get(bestTime.place), bestTime.start, max);
        bw.write(bestTime.place + " " + bestTime.start + " " + endTime);
        bw.flush();
        bw.close();
    }
    
    static int findEnd(TreeMap<Integer, Integer> timeSlots, int start, int max) {
        int end = start;
        while (timeSlots.containsKey(end) && timeSlots.get(end) == max) {
            end++;
        }
        return end;
    }
}