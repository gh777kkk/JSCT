package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_j_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] book = new String[N];

        for(int i = 0; i < N; i++){
            book[i] = br.readLine();
        }

        // 많이 팔린 책의 수가 같은경우에 사전순으로 출력하기 위해 정렬
        Arrays.sort(book);

        //초기 값 세팅
        String maxBook = book[0];
        int maxCnt = 1;
        int cnt = 1;

        for(int i = 1; i < N; i++){
            //이전 값과 같은 문자면 cnt값 증가
            if(book[i].equals(book[i-1])){
                cnt++;

                // 마지막 문자열에서 같은 경우에 maxCnt 보다 크면 MaxBook 재정의
                if(maxCnt < cnt && i == N-1){
                    maxBook = book[i];
                }

            }
            else{
                // maxCnt 보다 cnt값이 클경우 maxBook, maxCnt 값 재정의 한후 cnt 값 초기화
                if(maxCnt < cnt){
                    maxCnt = cnt;
                    maxBook = book[i-1];
                }
                cnt = 1;
            }
        }

        System.out.println(maxBook);
    }
}
