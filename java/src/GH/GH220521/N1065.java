package GH.GH220521;

import java.io.*;

//        문제
//        어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
//
//        출력
//        첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
public class N1065 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int result;
        int len = (int)(Math.log10(n)+1);
        if (len < 3) result = n;                // 1, 2 자리숫자는 무조건 한수이다.
        else {
            result = 99;
            for (int i = 100; i <= n; i++){     // 1000은 한수가 아니고 최댓값이 1000이기 때문에 무조건 3자리수만 계산하면 된다.
                if (i == 1000) break;           // 1000은 4자리숫자 이기때문에 예외 처리
                if ( ( (i%100/10) - (i%10) ) == ( (i%1000/100) - (i%100/10) ) ) ++result;       // 3자리 수에 한수면 +1 을 해준다
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
