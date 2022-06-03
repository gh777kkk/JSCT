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
                if (i != progresses.length-1) continue;
            } else {
                int day = (100 - progresses[i])%speeds[i] == 0 ? (100 - progresses[i])/speeds[i] : (100 - progresses[i])/speeds[i] + 1;
                for (int j = i; j < progresses.length; j++){
                    progresses[j] += day * speeds[j];
                }
                i--;
            }
            if (cnt != 0) answer.add(cnt);
            cnt = 0;
        }
        return answer;
    }
}
