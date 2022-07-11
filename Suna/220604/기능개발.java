import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Queue 이용한 탐색
 *
 */
public class 기능개발 {

    public static void main (String[] args) {
      int[] progresses = {95, 90, 99, 99, 80, 99};
      int[] speeds = {1, 1, 1, 1, 1, 1};

      solution(progresses, speeds);
    }

    public static int[] solution (int[] processes, int[] speeds) {

      List<Integer> answer = new LinkedList<>();

      // 기능 완료를 위해 필요한 날짜
      Queue<Integer> queue = new LinkedList<>();

      // 날짜를 queue 안에 저장하기
      for (int i = 0; i < processes.length; i++) {
        int day = (100 - processes[i]) / speeds[i];
        // 날짜가 맞아 떨어지지 않을때
        if ((100 - processes[i]) % speeds[i] > 0) {
          queue.add(day + 1);
        } else {
          queue.add(day);
        }
      }
      int standard = queue.poll();
      int count = 1;
      // 날짜 탐색하며 standard 와 현재 날짜 비교하며
      // count update
      while (!queue.isEmpty()) {
        int temp = queue.poll();

        if (temp <= standard) {
          count++;
        } else {
          answer.add(count);
          //init
          count = 1;
          standard = temp;
        }
      }

      // temp pointer = days.length - 1
      answer.add(count);

      //System.out.println(Arrays.toString(answer.stream().mapToInt(Integer::intValue).toArray()));

      return answer.stream().mapToInt(i -> i).toArray();
    }
}
