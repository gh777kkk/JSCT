import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *  Comparator 이용하여 순서 배열 나열
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
        if (o1.length() == o2.length()) {
          int sumO1 = getSum(o1);
          int sumO2 = getSum(o2);

          if (sumO1 == sumO2) return o1.compareTo(o2);
          return sumO2-sumO1;
        }
        return o1.length() - o2.length();
      }
    });
  }

  public static int getSum (String word) {
    return Arrays.stream(word.split(""))
        .filter(i -> i.matches("^[0-9]+$")) //regExpression
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
