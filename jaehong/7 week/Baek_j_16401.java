package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_j_16401 {
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

        int result = 0;
        int start = 1;
        int end = input[N-1];

        while(start <= end){
            int cnt = 0;
            int mid = (start+end)/2;

            for(int i = 0; i < N; i++){
                cnt += input[i]/mid;
            }

            if(cnt >= nephewCnt) {
                if(result < mid) result = mid;
                start = mid+1;
            }
            else end = mid-1;

        }

        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}
