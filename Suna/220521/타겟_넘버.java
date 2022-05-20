

/**
 * DFS 이용
 * time compelexity : O(V + E)
 *  - O(V) = V is the number of nodes.
 *  - O(E) = e sizes of the adjacency lists of all the nodes is E.
 *
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers,
 * 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를
 * return 하도록 solution 함수를 작성해주세요.
 *
 * 1         1
 *        +   -
 * 2     1       1
 *     +   -     + -
 * 3   1   1     1  1
 *    + -  + -  + - + -
 * 4  1  1 1 1  1  1 1 1
 *
 */
public class 타겟 {

  static int answer = 0;

  public static void main(String[] args) {
    int[] list = {1,1,1,1,1};
    System.out.println(solution(list, 3));
  }

  public static int solution(int[] numbers, int target) {
    findWithDfs(numbers, target, 0, 0);
    return answer;
  }

  /**
   * DFS (깊이 우선 탐색)
   * 깊이로 탐색하여 하나씩 노드를 바꿈.
   *
   * @param list
   * @param target
   * @param depth
   * @param total
   */
  public static void findWithDfs (int[] list, int target, int depth, int total) {
    if (list.length == depth) { //마지막 노드
      if (total == target) answer++;
      return;
    }
    // minus
    findWithDfs(list, target, depth + 1, total - list[depth]);
    // plus
    findWithDfs(list, target, depth + 1, total + list[depth]);
  }
}