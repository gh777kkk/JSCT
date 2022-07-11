package GH.GH220528;


//        문제
//        Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다. 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다. 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
//
//        끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
//
//        출력
//        첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1049 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] pack = new int[m];
        int[] one = new int[m];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack);  // pack[0] 은 6개 팩중 최저가
        Arrays.sort(one);   // one[0] 은 단일 갯수중 최저가

        // 처음에 1가게에서 구매하는 최저가를 구해야 되는줄 알고 이해 불가.....
        int result = one[0] * n;                                                    // 단일 수량으로만 구매 했을때 최저가
        result = Math.min(result, ( (n/6)+1) * pack[0] );                           // 6개 팩으로 구매했을때 최저가
        result = Math.min(result, ( ( (n/6) * pack[0] ) + ( (n%6) *one[0] ) ));     // 6개팩하고 나머지를 단일수량 으로 구매했을때 최저가

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
