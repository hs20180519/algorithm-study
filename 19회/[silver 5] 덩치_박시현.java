import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      List<Person> people = new ArrayList<>();
      
      for(int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        people.add(new Person(a, b));
      }
      
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(people.get(j).w > people.get(i).w && people.get(j).h > people.get(i).h) {
            people.get(i).rank++;
          }
        }
      }
      
      for(Person p : people) {
        System.out.print(p.rank + " ");
      }
  }
}

class Person {
  int w, h, rank;
  Person(int w, int h) {
    this.w = w;
    this.h = h;
    this.rank = 1;
  }
}
