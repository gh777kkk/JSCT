package GH.GH220716;

import java.io.*;
import java.util.Arrays;

public class B11656 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String[] list = new String[s.length()];

        for (int i = 0; i < s.length(); i++){
            list[i] = s.substring(i);
        }

        Arrays.sort(list);
        for (String data : list){
            sb.append(data).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
