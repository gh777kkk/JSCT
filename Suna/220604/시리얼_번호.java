import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *  Comparator 이용하여 순서 배열 나열
 *
 *  기본 정렬조건이 오름차순 인 이유는 Class 내에 기본적으로 구현되어있는
 *  Comparable Interface의 compareTo 메서드를 기준으로 하기 때문입니다.
 *  Java에서 인스턴스를 서로 비교하는 클래스들은 모두 Comparable 인터페이스가 구현
 *  byte, char, double, short, long, int, float같은
 *  PrimitiveType의 배열에는 적용이 불가능하니 Integer같은 Wrapper "Class"를 이용하셔야 한다는 점
 *
 *  Arrays.sort => 시간복잡도 (평균 : O(nlog(n)) / 최악 : O(n^2))
*/
public class 시리얼_번호 {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    int count = sc. nextInt();

    String[] wordList = new String[count];

    for (int i = 0; i < count; i++) {
      wordList[i] = sc.next();
    }

    Arrays.sort(wordList, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        //길이가 같다면
        if (o1.length() == o2.length()) {
          // A와 B 모든 자리 수 합 구하기
          int sumO1 = getSum(o1);
          int sumO2 = getSum(o2);
          // 사전순
          if (sumO1 == sumO2) return o1.compareTo(o2);
          return sumO1-sumO2;
        }
        // 문자열 길이 비교
        // 짧은 것이 먼저온다
        return o1.length() - o2.length();
      }
    });

    for(String w : wordList) {
      System.out.println(w);
    }
  }

  /**
   * 문자열의 문자가 숫자일 경우 그에 대한 합을 구한다.
   *
   * @param word
   * @return
   */
  public static int getSum (String word) {
    return Arrays.stream(word.split(""))
        .filter(i -> i.matches("^[0-9]+$")) //regExpression
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
