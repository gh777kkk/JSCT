package GH.GH220625;

//        문제
//        2007년 KOI에 N명의 학생들이 참가하였다. 경시일 전날인 예비소집일에, 모든 학생들은 자신이 N명 중에서 몇 등을 할 것인지 예상 등수를 적어서 제출하도록 하였다.
//
//        KOI 담당조교로 참가한 김진영 조교는 실수로 모든 학생의 프로그램을 날려 버렸다. 1등부터 N등까지 동석차 없이 등수를 매겨야 하는 김 조교는, 어쩔 수 없이 각 사람이 제출한 예상 등수를 바탕으로 임의로 등수를 매기기로 했다.
//
//        자신의 등수를 A등으로 예상하였는데 실제 등수가 B등이 될 경우, 이 사람의 불만도는 A와 B의 차이 (|A - B|)로 수치화할 수 있다. 당신은 N명의 사람들의 불만도의 총 합을 최소로 하면서, 학생들의 등수를 매기려고 한다.
//
//        각 사람의 예상 등수가 주어졌을 때, 김 조교를 도와 이러한 불만도의 합을 최소로 하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 500,000) 둘째 줄부터 N개의 줄에 걸쳐 각 사람의 예상 등수가 순서대로 주어진다. 예상 등수는 500,000 이하의 자연수이다.
//
//        출력
//        첫째 줄에 불만도의 합을 최소로 할 때, 그 불만도를 출력한다.

import java.io.*;
import java.util.*;

public class B2012 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] list = new int[n];

        for (int i = 0; i < n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);
        /*
        *
        *   입력된 수를 오름차순으로 정렬
        *   자신의 인덱스가 순위고 그 차이를 절댓값으로 합계에 더 해줌
        *   ex) 1 5 3 1 2 -> 1 1 2 3 5 -> 0 + 1 + 1 + 1 + 0 = 3
        *   결과는 오답 왜 오답인가?? 모르겠다...
        *
         */

        for (int i = 0; i < n; i++){
            result += Math.abs(list[i]-(i+1));
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
