package GH.GH220723;

import java.io.*;
import java.util.StringTokenizer;

public class B2491 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 1;
        int max = 1;
        int before = 0;

        int[] list = new int[n];
        for (int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++){
            if (before == 0){
                cnt++;
                if (list[i-1] > list[i]) before = 1; //내림 차순
                if (list[i-1] < list[i]) before = 2; //오름 차순
                max = Math.max(cnt, max);
            }
            else if (before == 1){
                if (list[i-1] >= list[i]) cnt++;
                else {
                    before = 2;
                    max = Math.max(cnt, max);
                    cnt = 2;
                }
            }
            else {
                if (list[i-1] <= list[i]) cnt++;
                else {
                    before = 1;
                    max = Math.max(cnt, max);
                    cnt = 2;
                }
            }
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
