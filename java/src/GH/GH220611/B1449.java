package GH.GH220611;

//        문제
//        항승이는 품질이 심각하게 나쁜 수도 파이프 회사의 수리공이다. 항승이는 세준 지하철 공사에서 물이 샌다는 소식을 듣고 수리를 하러 갔다.
//
//        파이프에서 물이 새는 곳은 신기하게도 가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샌다.
//
//        항승이는 길이가 L인 테이프를 무한개 가지고 있다.
//
//        항승이는 테이프를 이용해서 물을 막으려고 한다. 항승이는 항상 물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다.
//
//        물이 새는 곳의 위치와, 항승이가 가지고 있는 테이프의 길이 L이 주어졌을 때, 항승이가 필요한 테이프의 최소 개수를 구하는 프로그램을 작성하시오. 테이프를 자를 수 없고, 테이프를 겹쳐서 붙이는 것도 가능하다.
//
//        입력
//        첫째 줄에 물이 새는 곳의 개수 N과 테이프의 길이 L이 주어진다. 둘째 줄에는 물이 새는 곳의 위치가 주어진다. N과 L은 1,000보다 작거나 같은 자연수이고, 물이 새는 곳의 위치는 1,000보다 작거나 같은 자연수이다.
//
//        출력
//        첫째 줄에 항승이가 필요한 테이프의 개수를 출력한다.

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1449 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);      // 오름차순 정렬

        for (int i = 0; i < n; i++){
            if (i == 0) {       // 처음에는 무조건 테이프 1개 필요하고 지금 위치에서 테이프 길이를 더해준다.
                result++;
                list[i] += l;
            } else if (list[i] < list[i-1]){    // 현제 idx 의 값과 바로 직전 idx 의 값중 직전 idx 의 값이 크면 그냥 이전 테이프로 막은거다.
                list[i] = list[i-1];
            } else {                            // 직전 idx 의 값이 적으면 새 테이프 필요
                result++;
                list[i] += l;
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
