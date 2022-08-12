package GH.GH220813;

import java.io.*;
import java.util.StringTokenizer;

public class B14916 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n>0){
            if (n%5 == 0) {
                cnt += n/5;
                break;
            } else {
                cnt++;
                n -= 2;
            }
        }
        if (n < 0) cnt = -1;

        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
