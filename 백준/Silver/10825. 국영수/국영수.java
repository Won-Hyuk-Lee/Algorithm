import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int kor, eng, math;
        
        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(
                st.nextToken(),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            ));
        }
        
        list.sort((s1, s2) -> {
            if (s1.kor != s2.kor) return s2.kor - s1.kor;
            if (s1.eng != s2.eng) return s1.eng - s2.eng;
            if (s1.math != s2.math) return s2.math - s1.math;
            return s1.name.compareTo(s2.name);
        });
        
        StringBuilder sb = new StringBuilder();
        for (Student s : list) sb.append(s.name).append('\n');
        System.out.print(sb);
    }
}