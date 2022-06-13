package GH.GH220618;


import java.util.*;

public class K번째수 {
    public static void main (String[] arg){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];
            int[] list = new int[end-start+1];
            for (int j = 0; j < end-start+1; j++){
                list[j] = array[start-1+j];
            }
            Arrays.sort(list);
            answer[i] = list[idx-1];
        }
        return answer;
    }
}
