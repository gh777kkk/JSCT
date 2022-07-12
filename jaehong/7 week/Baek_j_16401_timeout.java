package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_j_16401_timeout {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nephewCnt = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int input[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(input);

        int result = input[N-1];

        while(true){
            int cnt = 0;

            for(int i = N-1; i >= 0; i--){
                if(input[i] < result) break;
                cnt += input[i]/result;
            }

            if(cnt == nephewCnt) break;

            result--;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}
