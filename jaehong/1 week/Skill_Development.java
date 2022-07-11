package Stack;
import java.util.*;

public class Skill_Development {

    public List<Integer> solution(int[] progresses, int[] speeds) {
        //정답을 담을 배열과 일수를 담을 배열을 선언
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        // 전체 배열의 각각의 일수를 list배열에 할당
        for(int i = 0; i < progresses.length; i++){
            int day = 0;
            while(true){
                if(progresses[i] < 100){
                    progresses[i] += speeds[i];
                    day++;
                }
                else{
                    list.add(day);
                    break;
                }
            }
        }

        // 순서대로 진행되기 떄문에 첫 인덱스에 해당되는 값을 max 값으로 할당.
        int cut = 1;
        int max = list.get(0);
        for(int i =1; i < list.size(); i++){
            // max 값 보다 다음 값이 크다면 max 값을 해당 값으로 바꾸고 정답 배열에 cut값 할당 후 cut값은 1로 초기화.
            if(list.get(i) > max){
                max = list.get(i);
                answer.add(cut);
                cut = 1;
            }
            // max 값보다 작은 경우에는 바로 배포가능하므로 cut값만 증가 시킨다.
            else{
                cut++;
            }
        }
        answer.add(cut);

        return answer;
    }
}
