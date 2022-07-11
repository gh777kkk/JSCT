package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_j_2512 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int bud[] = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            bud[i] = Integer.parseInt(st.nextToken());
            sum +=  bud[i];
        }

        // 총 예산
        int total_bud = Integer.parseInt(br.readLine());

        // 예산 상한보다 커지면 바로 반복을 종료하기 위해서 정렬
        Arrays.sort(bud);

        if(sum <= total_bud){
            System.out.println(bud[N-1]);
            return;
        }

        // 총 예산에서 지방의 수를 나눈값 (상한값)
        int result = total_bud/N;

        // 상한 예산 보다 작은 값의 수
        int cnt = 0;

        for(int i = 0; i  < N; i++){

            if(bud[i] < result){
                // 상한값보다 작으므로 cnt 값을 증가 시킨 후 총예산에서 현재 예산을 뺴준후 상한값 갱신
                cnt++;
                total_bud -= bud[i];
                result = total_bud / (N - cnt);
            }

            // 지방 예산이 상한값보다 클때는 그 값이 상한값 ( sort를 한 이유 )
            else break;

        }
        System.out.println(result);
    }
}
