package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_j_2667 {

    public static int map[][];
    public static int N;

    // 단지 내에있는 집 수
    public static int cut[];

    // 단지의 수
    public static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i+1][j+1] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        // 단지가 몇개 인지 모르기 때문에 최대값으로 크기 설정
        cut = new int[626];

        // 모든 위치에서 dfs 진행
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                // 값이 true면 방문하지 않은 단지
                if(dfs(i,j)){
                    result++;
                }
            }
        }
        int hCut[] = new int[result];

        for(int i = 0; i < result; i++){
            hCut[i] = cut[i];
        }

        Arrays.sort(hCut);

        System.out.println(result);
        for(int i = 0; i < hCut.length; i++){
            System.out.println(hCut[i]);
        }
    }

    public static boolean dfs(int x, int y){

        if(x <= 0 || x > N || y <= 0 || y > N){
            return false;
        }

        if(map[x][y] == 1){
            // 방문처리
            map[x][y] = 0;
            //해당 단지에 집의 수 증가
            cut[result]++;

            dfs(x-1,y);
            dfs(x+1, y);
            dfs(x,y-1);
            dfs(x,y+1);

            return true;
        }
        return false;
    }

}
