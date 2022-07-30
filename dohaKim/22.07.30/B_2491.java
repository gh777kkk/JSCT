import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[2][n+1];
        // 0 : 증가
        // 1:  감소
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i]) {
                dp[0][i] = dp[0][i-1] + 1;
                dp[1][i] = 1;
            } else if (arr[i-1] > arr[i]){
                dp[1][i] = dp[1][i-1] + 1;
                dp[0][i] = 1;
            } else if (arr[i-1] == arr[i]) {
                dp[0][i] = dp[0][i-1] + 1;
                dp[1][i] = dp[1][i-1] + 1;
            }
        }

//        for(int i = 1; i < n; i++){
//            System.out.print(dp[0][i]);
//        }
//        System.out.println();
//
//        for(int i = 1; i < n; i++){
//            System.out.print(dp[1][i]);
//        }

        int increase_max = Arrays.stream(dp[0]).max().getAsInt();
        int decrease_max = Arrays.stream(dp[1]).max().getAsInt();
        System.out.println(Math.max(increase_max, decrease_max));
    }
}


