package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_j_1182 {
    static int N;
    static int S;
    static int input[];
    static boolean vi[];
    static int cut = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[N];
        vi = new boolean[N];

        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            dfs(0,0,i);
        }


        System.out.println(cut);

    }
    private static void dfs(int v , int sum, int dep){

        if(v==dep){
            if(sum == S){
                cut++;
            }
            return;
        }


        dfs(v+1, sum+input[v], dep);


    }
}

