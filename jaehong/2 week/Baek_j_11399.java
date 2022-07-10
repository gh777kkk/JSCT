package Algorithm;

import java.io.*;
import java.util.*;

public class Baek_j_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int sum = 0;
        int result = 0;
        for(int i = 0; i < N ;i++){
            sum += input[i];
            result += sum;
        }

        System.out.print(result);
    }
}

