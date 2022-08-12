package GH.GH220813;

import java.io.*;

public class B1439 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int cnt = 0;

        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) != s.charAt(i+1)) cnt++;
        }
        if (cnt%2 == 1) cnt++;

        sb.append(cnt/2);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
