package Algorithm;

import java.util.*;
import java.io.*;

public class Baek_j_11724 {
    static int N;
    static int M;
    static int input[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N][N];
        boolean vi[] = new boolean[N];


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            input[x-1][y-1] = 1;
            input[y-1][x-1] = 1;
        }

        int cnt = 0;

        for(int i = 0; i < N; i++){
            if(!vi[i]){
                cnt++;
                dfs(i,vi);
            }
        }
        System.out.print(cnt);
    }

    public static void dfs(int x,boolean vi[]) {
        vi[x] = true;

        for(int i = 0; i < N; i++){
            if(input[x][i] == 1 && !vi[i]){
                dfs(i,vi);
            }
        }
    }

}

