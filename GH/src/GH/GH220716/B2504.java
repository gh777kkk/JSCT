package GH.GH220716;

import java.io.*;
import java.util.Stack;

public class B2504 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] n = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 1;

        for (int i = 0; i < n.length; i++){
            if (i == 0 && (n[i] == ')' || n[i] == ']')) {
                result = 0;
                break;
            }
            if (i == n.length-1 && (n[i] == '(' || n[i] == '[')) {
                result = 0;
                break;
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
