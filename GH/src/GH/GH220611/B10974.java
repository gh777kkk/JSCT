package GH.GH220611;

//        문제
//        N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
//
//        출력
//        첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10974 {
    private static StringBuilder sb;
    private static int n;
    private static boolean[] visit;
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];

        for (int i = 1; i <= n ; i++){
            visit[i] = true;
            String result = i+"";
            dfs(1,result);
            visit[i] = false;
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int idx,String result){
        if (idx == n) {
            sb.append(result).append('\n');
            return;
        }
        for (int i = 1; i <= n; i++){
            if (visit[i]) continue;
            visit[i] = true;
            result += " "+i;
            dfs(idx+1,result);
            result = result.substring(0,result.length()-2); //49라인의 숫자를 삭제해줘야함
            visit[i] = false;
        }
    }
}
