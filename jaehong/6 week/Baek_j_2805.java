package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_j_2805 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        long input[] = new long[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서 부터 찾기 위해 정렬
        Arrays.sort(input);
        long result = input[N-1];

        if(target == 0) {
            System.out.println(result);
            return;
        }

        while (result >= 0){
            result--;
            // 자른 나무의 합
            long sum = 0;
            for(int i = N-1; i >= 0; i--){
                // sort 했기 때문에 자를 높이 보다 나무가 낮다면 뒤에있는 나무도 다 낮으므로 반복문 종료
                if(input[i] <= result) break;
                else sum += (input[i] - result);
            }

            // 자른 나무의 길이의 합이 목표 길이보다 크다면 while문 종료
            if(sum >= target) {
                break;
            }
        }
        System.out.println(result);

    }
}
