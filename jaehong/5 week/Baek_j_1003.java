package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_j_1003 {
    public static int zeroCnt;
    public static int oneCnt;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            zeroCnt = 0;
            oneCnt = 0;
            int fiboNum = Integer.parseInt(br.readLine());
            int fibo[] = new int[fiboNum+1];

            if(fiboNum == 0) {
                sb.append(1 + " " + 0).append('\n');
                continue;
            }
            if(fiboNum == 1) {
                sb.append(0 + " " + 1).append('\n');
                continue;
            }

            fibo[0] = 0;
            fibo[1] = 1;

            for(int j = 2; j <= fiboNum; j++){
                fibo[j] = fibo[j-1] + fibo[j-2];
            }

            sb.append(fibo[fiboNum-1] + " " + fibo[fiboNum]).append('\n');
        }

        System.out.print(sb);
    }

}
