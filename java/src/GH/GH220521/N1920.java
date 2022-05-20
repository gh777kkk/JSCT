package GH.GH220521;

import java.io.*;
import java.util.StringTokenizer;

//        문제
//        N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
//
//        출력
//        M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
public class N1920 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = Integer.parseInt(stn.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer stm = new StringTokenizer(br.readLine());
        int[] ma = new int[m];
        for (int i = 0; i < m; i++){
            ma[i] = Integer.parseInt(stm.nextToken());
        }

        int[] result = new int[m];
        for (int i = 0; i < m; i++){
            result[i] = 0;
            for (int j = 0; j < n; j++){
                if (a[j] == ma[i]) {
                    result[i] = 1;
                    break;
                }
            }
        }
        for (int i : result){
            sb.append(i).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}