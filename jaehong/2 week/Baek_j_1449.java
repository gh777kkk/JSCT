package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_j_1449 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 구멍난 갯수
        int N = Integer.parseInt(st.nextToken());
        // 테이프의 길이
        int t_leng = Integer.parseInt(st.nextToken());
        // 구멍난 위치
        int h_loc[] = new int[N];
        int cnt = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            h_loc[i] = Integer.parseInt(st.nextToken());
        }

        // 구멍난 위치를 순서대로 하기 위해
        Arrays.sort(h_loc);

        for(int i = 0; i < N-1; i++){
            // 테이프의 길이보다 작으면 다음으로 연결될 가능성이 있기 때문에 트레이트 시켜준다.
            if((h_loc[i+1]-h_loc[i]) < t_leng){
                h_loc[i+1] = h_loc[i];
            }
            // 길이가 길다면 cnt 값 증가
            else cnt++;
        }

        System.out.print(cnt);
    }
}
