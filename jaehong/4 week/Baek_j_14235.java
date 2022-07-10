package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_j_14235 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 거점을 방문했는지 아이들에게 방문했는지 체크
            int check = Integer.parseInt(st.nextToken());

            if(check != 0){

                for(int j = 0; j < check; j++){

                    int pv = Integer.parseInt(st.nextToken());
                    que.add(pv);
                }
            }
            else {

                if(que.isEmpty()) sb.append(-1).append('\n');
                else sb.append(que.poll()).append('\n');
            }
        }

        System.out.print(sb.toString());

    }

}
