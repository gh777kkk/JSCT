package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_j_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int per01 = Integer.parseInt(st.nextToken());
        int per02 = Integer.parseInt(st.nextToken());
        int cnt = 0;


        while(true){
            // 반복이 1번 될때 마다 1라운드씩 진행
            cnt++;

            // 두사람의 위치가 홀수면 1씩증가.
            if(per01 % 2 == 1) per01++;
            if(per02 % 2 == 1) per02++;

            // 증가 시켰을때 같으면 해당 라운드에 만나는 것임.
            if(per01 == per02){
                break;
            }

            // 토너먼트 이기 때문에 1 라운드가 진행 되면 2로 나눈다.
            per01 /= 2;
            per02 /= 2;
        }

        System.out.println(cnt);
    }
}
