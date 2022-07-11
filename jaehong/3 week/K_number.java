import java.util.*;

class K_number {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < answer.length; i++){

            // 자른 배열의 크기
            int arr[] = new int[commands[i][1] - commands[i][0] +1];

            // 배열 입력
            for(int j = commands[i][0]-1,k = 0; j < commands[i][1]; j++,k++){
                arr[k] = array[j];
            }

            //정렬
            Arrays.sort(arr);

            // 해당하는 값
            answer[i] = arr[commands[i][2]-1];

        }

        return answer;
    }
}