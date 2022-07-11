package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_j_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N+1];
        int dp[] = new int[N+1];

        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        // 첫 번째 계단의 경우의 수 1가지
        dp[1] = input[1];

        // 2번쨰 계단도 올수있는 경우의 수는 1개지만 계단이 1개 밖에 없는 경우에 예외가 발생하므로 조건문을 작성
        if(N >= 2) dp[2] = input[1]+input[2];

        for(int i = 3; i <= N; i++){
            // 2번째 전 계단의 최대값과, 3번째 전 계단의 최대 값 + 1번째 전 계단의 점수 중 큰 쪽을 현재 계단의 최대값으로 정한다.
            dp[i] = Math.max(dp[i-2],dp[i-3] + input[i-1]) + input[i];
        }

        System.out.println(dp[N]);

        
    }
}
