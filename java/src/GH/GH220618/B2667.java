package GH.GH220618;

//        문제
//        <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
//
//
//
//        입력
//        첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
//
//        출력
//        첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

import java.io.*;
import java.util.*;

public class B2667 {
    private static boolean[][] visit;
    private static int[][] list;
    private static int cnt = 0;
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        list = new int[n][n];
        visit = new boolean[n][n];
        ArrayList<Integer> cnt_list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < n; j++){
                list[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (list[i][j] == 1 && !visit[i][j]){       // 현제 idx 값이 1이고 방문한적이 없다면
                    result++;
                    dfs(i,j);
                    cnt_list.add(cnt);
                    cnt = 0;
                }
            }
        }

        sb.append(result).append('\n');
        Collections.sort(cnt_list);                         // 오름차순 정렬

        for (int data : cnt_list){
            sb.append(data).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int x, int y){
        if (list[x][y] == 0 || visit[x][y]) return;

        cnt ++;
        visit[x][y] = true;

        if (x > 0) dfs(x-1 , y);
        if (y > 0) dfs(x , y-1);
        if (x < list.length-1) dfs(x+1 , y);
        if (y < list.length-1) dfs(x , y+1);
    }
}
