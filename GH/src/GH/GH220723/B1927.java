package GH.GH220723;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1927 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //PriorityQueue 우선순위 큐 Integer 는 숫자가 작을 수록 우선순위가 높다.

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if (queue.size() == 0) sb.append(0).append('\n');
                else sb.append(queue.poll()).append('\n');
            }else queue.add(x);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
