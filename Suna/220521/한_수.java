/**
 *  백준 한 수
 *  완전탐색??
 *  time complexity : O(N)
 *
 *  ❓ 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
 *  등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때,
 *  1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 *     -> 1<=X && N<=X 한수의 개수
 *     등차 수열 공식 : a + (n-1)d
 *
 *     ⏩ 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.   es) 110
 *     1000 보다작고 등차수열 이려면 적어도 세 숫자 존재
 *     자리수 : 1 1 1 1 || 1 1 2 -- 네 자리수는 제외
 *
 *     ⏪ 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다. ex) 99
 */
public class 한_수 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(findArithmeticSequence(n));
  }

  public static int findArithmeticSequence(int n) {
    int count = 0;
    // 1~두자리 수까지는 무조건 등차수열
    // 100~999까지는 각자리 비교해서 등차수열인지 확인
    // 1000 : 등차수열 될수 없음
    for (int x = 1; x <= n; x++) {
      if (x < 100) count++;
      else {
        int hun = x / 100;
        int ten = (x % 100) / 10;
        int one = (x % 100) % 10;

        if (hun-ten == ten-one) count++;
      }
    }
    return count;
  }
}