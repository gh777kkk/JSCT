package GH.GH220611;

//        문제
//        방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
//
//        출력
//        첫째 줄에 연결 요소의 개수를 출력한다.

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11724 {
    private static boolean[] visit;
    private static int[][] list;
    private static int result;
    private static int n;
    private static int m;
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n+1][n+1];           // 0은 안쓰고 1부터 사용해서 입력 숫자와 idx 의 일치
        visit = new boolean[n+1];
        result = 0;

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            list[one][two] = list[two][one] = 1;        // 접점이 있으면 1 없으면 0
        }

        for(int i = 1; i <= n; i++){
            if (!visit[i]){                             // 초기 false 고 true 면 패스
                dfs(i);
                result++;
            }
        }


        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs (int idx){
        if(visit[idx]) return;
        visit[idx] = true;

        for (int i = 1 ; i <= n; i++){
            if (list[idx][i] == 1) dfs(i);
        }
    }
}
