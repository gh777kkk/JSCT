package GH.GH220611;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프린터 {
    public static void main (String[] arg){
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++){
            queue.add(priorities[i]);
            idx.add(i);
        }

        while (queue.size() != 0){
            int big = 0;
            int cnt = 0;
            for (int i = 0; i < queue.size(); i++){
                if (big < queue.peek()) {       // 가장 큰 숫자(우선순위가 가장 높음)를 찾기 위해서
                    big = queue.peek();
                    cnt = i;                    // 가장 큰 숫자의 idx
                }
                queue.add(queue.poll());        // 큐의 맨앞 숫자를 맨뒤로
            }
            if (location == idx.get(cnt)) return answer+1; // 가장 큰 숫자의 idx 와 location 의 값이 같으면 리턴
            if (cnt == 0){
                idx.remove(0);                  // 큐의 맨앞 숫자가 가장 클 경우 idx 의 가장 앞 삭제 큐 가장 앞 삭제
                queue.poll();
            }else{
                for (int i = 0; i < cnt; i++){
                    idx.add(idx.remove(0));     // 가장 큰 숫자 앞에 숫자들은 순차적으로 뒤로 보내준다 idx 도 따라서
                    queue.add(queue.poll());
                }
                idx.remove(0);                  // 가장 앞 숫자 삭제
                queue.poll();
            }
            answer++;
        }
        return answer;
    }
}
