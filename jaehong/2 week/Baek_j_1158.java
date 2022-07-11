package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_j_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sb.append('<');

        br.close();

        for(int i = 1; i <= N; i++){
            que.offer(i);
        }

        int i = 1;

        while(!que.isEmpty()){

            if(i == M && que.size() > M){
                int num = que.remove();
                sb.append(num).append(", ");
                i = 1;
                continue;
            }
            else if(que.size() <= M){
                if(que.size() == 1){
                    int num = que.remove();
                    sb.append(num).append('>');
                    break;
                }

                for(int j = 0; j < M; j++){
                    if(j == M-1){
                        int num = que.remove();
                        sb.append(num).append(", ");
                    }
                    else{
                        int num = que.remove();
                        que.add(num);
                    }
                }
            }
            else {
                int num = que.remove();
                que.add(num);
                i++;
            }
        }
        System.out.print(sb);
    }
}
