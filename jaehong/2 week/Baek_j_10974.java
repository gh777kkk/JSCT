package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_j_10974 {
    static int N;
    static boolean vi[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vi = new boolean[N];
        int arr[] = new int[N];

        dt(0,arr);
    }
    public static void dt(int dep,int arr[]){
        if(dep == N){
            for(int var : arr){
                System.out.print(var + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++){
            if(!vi[i]){
                vi[i] = true;
                arr[dep] = i +1;
                dt(dep+1,arr);
                vi[i] = false;
            }
        }
    }
}
