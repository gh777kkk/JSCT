package GH.GH220618;

//        문제
//        N×M크기의 배열로 표현되는 미로가 있다.
//
//        1	0	1	1	1	1
//        1	0	1	0	1	0
//        1	0	1	0	1	1
//        1	1	1	0	1	1
//        미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
//        위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
//
//        입력
//        첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
//
//        출력
//        첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
    private static int n;
    private static int m;
    private static boolean[][] visit;
    private static int[][] list;
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < m; j++){
                list[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs(0,0);

        sb.append(list[n-1][m-1]);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs (int x, int y) {
        Queue<int[]> q = new LinkedList<>();        // java 에서 bfs 를 구현할때 보통 queue 를 이용한다.
        q.add(new int[] {x,y});

        while (!q.isEmpty()){
            int[] location = q.poll();
            x = location[0];
            y = location[1];
            if (x < n-1 && list[x+1][y] != 0 && !visit[x+1][y]) {
                q.add(new int[] {x+1,y});
                list[x+1][y] = list[x][y]+1;
                visit[x+1][y] = true;
            }
            if (y < m-1 && list[x][y+1] != 0 && !visit[x][y+1]) {
                q.add(new int[] {x,y+1});
                list[x][y+1] = list[x][y]+1;
                visit[x][y+1] = true;
            }
            if (x > 0 && list[x-1][y] != 0 && !visit[x-1][y]) {
                q.add(new int[] {x-1,y});
                list[x-1][y] = list[x][y]+1;
                visit[x-1][y] = true;
                            }
            if (y > 0 && list[x][y-1] != 0 && !visit[x][y-1]) {
                q.add(new int[] {x,y-1});
                list[x][y-1] = list[x][y]+1;
                visit[x][y-1] = true;
            }
        }
    }
}
