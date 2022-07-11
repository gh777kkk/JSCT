package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_j_14425 {
    public static void main(String[] args) throws IOException{

        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 집합 S를 담을 문자열
        String[] strArr = new String[N];

        // 집합 S에 포함되어있는지 검사해야한 문자열
        String[] checkArr = new String[M];

        for(int i = 0; i < N; i++){
            strArr[i] = br.readLine();
        }

        for(int i = 0; i < M; i++){
            checkArr[i] = br.readLine();
        }

        // 이중 for 문을 통해서 문자열을 비교 같으면 count 값을 증가 시킨다.
        for(int i = 0 ; i < M; i++){
            for(int j = 0; j < N; j++){
                if(strArr[j].equals(checkArr[i])){
                    cnt++;
                    break;
                }
            }
        }

        System.out.print(cnt);
    }
}
