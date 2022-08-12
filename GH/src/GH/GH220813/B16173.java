package GH.GH220813;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B16173 {

    static int[][] list;
    static String result = "Hing";
    static int n;

    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) list[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int x, int y){
        if (x == n-1 && y == n-1) {
            result = "HaruHaru";
            return;
        }
        int len = list[x][y];
        for (int i = 0; i < list[x][y]; i++){
            if ((x+len-i) < n && y+i < n) dfs(x+len-i, y+i);
        }
    }
}
