package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_j_2178 {

    public static int map[][];
    // 방향 vector 정의
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        System.out.print(bfs(0,0));

    }

    public static int bfs(int x, int y){

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        //처음 위치를 큐에 담는다.
        qx.offer(x);
        qy.offer(y);

        //큐의 값이 없을 때 까지 반복문을 돌린다.
        while(!qx.isEmpty() && !qy.isEmpty()){

            // 큐에 있는 값을 꺼낸다.
            x = qx.poll();
            y = qy.poll();

            // 해당 위치에서 갈수있는 방향만큼 반복문을 돌린다.
            for(int i = 0; i < 4; i++){
                //이동한 위치
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위를 벗어나는 조건문
                if( nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }

                if(map[nx][ny] == 0){
                    continue;
                }

                if(map[nx][ny] == 1){
                    map[nx][ny] = map[x][y]+1;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
        return map[N-1][M-1];
    }
}