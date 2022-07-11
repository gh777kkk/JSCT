package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_j_1269 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 전체 원소 갯수
        int cnt = N+M;
        if(N == 0 || M == 0){
            System.out.println(0);
            return;
        }

        // 중복되는 수의 갯수
        int resultCnt = 0;

        // 문제에서의 범위 만큼 배열을 잡아준다.
        int check[] = new int[100_000_001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int first = Integer.parseInt(st.nextToken());
            // 해당 값의 index 자리에 값을 증가 시켜준다.
            check[first]++;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){

            int secend = Integer.parseInt(st.nextToken());

            // 해당 값의 index 자리에 값이 있으면 중복되는 것이기 때문에 자리 값을 감소 시키고 중복되는 cnt 값을 증가 시킨다.
            if(check[secend] > 0){
                check[secend]--;
                resultCnt++;
            }
        }
        System.out.println( cnt - (resultCnt*2) );

    }
}
