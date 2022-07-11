package GH.GH220618;

//        문제
//        국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것이다. 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있다. 그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정한다.
//
//        모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
//        모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
//        예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150이라고 하자. 이 경우, 상한액을 127로 잡으면, 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 그 합이 484로 가능한 최대가 된다.
//
//        여러 지방의 예산요청과 국가예산의 총액이 주어졌을 때, 위의 조건을 모두 만족하도록 예산을 배정하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에는 지방의 수를 의미하는 정수 N이 주어진다. N은 3 이상 10,000 이하이다. 다음 줄에는 각 지방의 예산요청을 표현하는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 값들은 모두 1 이상 100,000 이하이다. 그 다음 줄에는 총 예산을 나타내는 정수 M이 주어진다. M은 N 이상 1,000,000,000 이하이다.
//
//        출력
//        첫째 줄에는 배정된 예산들 중 최댓값인 정수를 출력한다.

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class B2512 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Arrays.sort(list);                                                          // 오름차순 정렬
        int cnt = 0;

        /*
        *
        * 1. 예산의 요청 오름 차순으로 정렬 하면 가장 마지막 값이 가장 큰 숫자 이다.
        * 2. 예산에 요청을 못 받아 들이는 경우 바로 앞 값의 숫자로 가장 큰 숫자를 변경
        * ex ) 110 120 140 150 -> 110 120 140 140
        * 3. 요청의 합이 예산의 합 보다 작아 질때 까지 계속
        * ex ) 110 120 140 150 -> 110 120 120 120
        * 4. 몇개가 변경되었는지 카운트 해당 예제의 경우 140 150 이 120 으로 2개의 값이 변경 되었다
        * 5. 예산이 485 라면 110 120 120 120 = 470 으로 15 의 여유가 있다.
        * 6. 120 보다 큰 숫자는 2개로 2개의 예산이 같아야 한다.
        * 7. 5번의 여유 값을 4번의 카운팅된 값으로 나눈 값으로 현제 카운팅 된 예산들에 더해주면 예산들 중 최댓값이 된다.
        * 8. 예외 상황으로 가장 적은 숫자로 커버가 안되는 경우가 있다.
        * ex ) 요청 : 110 120 140 150 예산 : 50 이라면 110 110 110 110 의 예산으로 안된다.
        * ex ) 50/4 = 12 ( java int 는 소숫점 버림 ) - > 12 12 12 12 - > 48
        *
        */

        if (IntStream.of(list).sum() <= m) sb.append(list[n-1]);                    // 최초 요청이 가능한 경우
        else{
            for (int i = n-1; i >= 0; i--){
                if (IntStream.of(list).sum() <= m) {
                    cnt = n-i-2;
                    break;
                }
                for (int j = i; j < n; j++){
                    list[j] = list[i];
                }
            }
            if (cnt == 0) sb.append( m/n );                                         // 가장 적은 숫자로 커버가 안될 때
            else sb.append( ((m-IntStream.of(list).sum())/cnt) + list[n-1]  );      // (총 예산 - list 합) /동시에 변경되어야 할 숫자 + list 에서 가장 큰 숫자
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
