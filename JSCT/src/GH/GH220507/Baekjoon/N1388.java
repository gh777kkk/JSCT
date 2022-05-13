package GH.GH220507.Baekjoon;

import java.io.*;
import java.util.*;

public class N1388 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;

        char[][] list = new char[n][m];

        for (int i = 0; i < n; i++){
            list[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (list[i][j] == '|'){
                    if (i == 0) result++;
                    else if (list[i-1][j] != '|') result++;
                }
                if (list[i][j] == '-'){
                    if (j == 0) result++;
                    else if (list[i][j-1] != '-') result++;
                }
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
