package GH.GH220528;

//        문제
//        문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
//
//        먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
//
//        알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
//        문자열의 시작과 끝은 공백이 아니다.
//        '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
//        태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
//
//        입력
//        첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.
//
//        출력
//        첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.


import java.io.*;
import java.util.Stack;

public class B17413 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack st = new Stack();     // 문자열 인버스를 위해서 스택을 사용
        boolean check = false;      // < > 속 인지 아닌지 boolean 으로 체크 한다.

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '<') {       // 받은 문자열을 charAt 으로 순서를 구별한다.
                while (!st.empty()){        // 스택에 값이 있다면 계속해서 반복한다.
                    sb.append(st.pop());    // 스택에 값이 있을때 sb에 값을 넣어주고 스택에서는 제거한다.
                }
                sb.append('<');             // 스택에 값이 있다면 sb에 넣어주고 없다면 그냥 < 를 sb에 넣어준다.
                check = true;               // <> 속 값일때 true
            } else if (check) {
                sb.append(s.charAt(i));     // true 는 <> 속 값이다 문자열을 그대로 넣어준다.
                if (s.charAt(i) == '>') check = false;
            } else {
                if(s.charAt(i) == ' ') {
                    while (!st.empty()) {
                        sb.append(st.pop());
                    }
                    sb.append(' ');
                } else st.push(s.charAt(i));
            }

            if (i == s.length()-1){
                while (!st.empty()) {
                    sb.append(st.pop());
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
