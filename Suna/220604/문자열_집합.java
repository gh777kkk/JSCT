import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  Hash Map 이용
 */
public class 문자열_집합 {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int s = sc.nextInt();

    Map<String, Integer> count = new HashMap<>();
  // m 집합 세트를 hashmap 안에 넣기
    for (int i = 0; i < m; i++) {
      String word = sc.next();
      count.put(word, 1);
    }

    int result = 0;
  // s에 포함되어 있는게 Hashmap 문자열과 존재하는지 확인
    for(int i = 0; i < s; i++) {
      String word = sc.next();
      if (count.containsKey(word)) result++;
    }

    System.out.println(result);
  }
}
