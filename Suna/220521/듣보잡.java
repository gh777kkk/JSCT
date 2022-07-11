import java.util.*;

/**
 * 문자열 처리
 * time complexity : O(N)
 *
 * N = 듣도 못한 수
 * M = 보도 못한 수
 * find N U M (듣도 보도 못한 사람 합집합 구하기)
 *
 */
public class 듣보잡 {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> answer = new ArrayList<>();

    int notHeard = sc.nextInt();
    int notSeen = sc.nextInt();

    Set<String> list = new HashSet<>();
    /**
     * HashSet time complexity : O(1)
     */
    for (int i = 0; i < notHeard; i++) {
      String name = sc.next();
      list.add(name);
    }

    for (int i = 0; i < notSeen; i++) {
      String name = sc.next();
      if (list.contains(name)) answer.add(name);
    }

    System.out.println("total: " + answer.size());
    answer.stream().sorted().forEach(pp ->
        System.out.println(pp)
    );
  }
}