package GH.GH220604;

import java.util.*;

public class 기능개발 {
    public static void main (String[] arg){
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.print(solution(progresses, speeds));
    }

    private static List<Integer> solution(int[] progresses, int[] speeds){
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < progresses.length; i++){
            if (progresses[i] >= 100) {
                ++cnt;
                if (i != progresses.length-1) continue;     // 마지막 idx 카운팅 하기 위해서
            } else {
                int day = (100 - progresses[i])%speeds[i] == 0 ? (100 - progresses[i])/speeds[i] : (100 - progresses[i])/speeds[i] + 1;     // 100 - 진도 를 속도로 나눌때 나머지가 없으면 그대로 나머지가 있으면 +1
                for (int j = i; j < progresses.length; j++){
                    progresses[j] += day * speeds[j];       // 지금 현재 숫자가 100밑이면 뒤에 숫자들은 전부 day * 작업속도
                }
                i--;                                        // 100 을 맞춰주고 해당 idx 부터 카운팅을 하기 위해서
            }
            if (cnt != 0) answer.add(cnt);                  // 100이 아닐때 패스하기 위해서
            cnt = 0;
        }
        return answer;
    }
}
