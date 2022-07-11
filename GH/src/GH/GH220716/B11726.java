package GH.GH220716;

import java.io.*;

public class B11726 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[1001];
        list[1] = 1;
        list[2] = 2;

        for (int i = 3; i <= n; i++) list[i] = (list[i-1] + list[i-2]) % 10007;

        sb.append(list[n]);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
