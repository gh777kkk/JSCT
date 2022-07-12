package Algorithm;

import java.io.*;

public class Baek_j_11726 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        long dp[] = new long[N+1];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= N; i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        bw.write(dp[N-1]%10007+"");
        bw.flush();
        bw.close();

    }
}
