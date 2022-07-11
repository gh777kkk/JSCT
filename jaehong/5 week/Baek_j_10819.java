package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_j_10819 {
    static int N;
    static int input[];
    static int max = Integer.MIN_VALUE;
    static boolean vi[];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[N];
        vi = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        bt(0,0,0);

        System.out.println(max);

    }
    // dep : 깊이. prev : 이전 값을 넣는 변수, sum : 총 합계
    public static void bt(int dep, int prev, int sum){

        if(dep == N){
            max = Math.max(max,sum);
            return;
        }
        for(int i = 0; i < N; i++){
            if(!vi[i]){
                vi[i] = true;
                // 깊이 증가, 현재값, 깊이가 0일 때는 합계가 없으므로 0, 1이상일때는 이전 값과 현재 값을 빼서 합계랑 더함.
                bt(dep+1, input[i], dep == 0 ? 0: sum + Math.abs(input[i]-prev));
                vi[i] = false;

            }
        }

    }
}
