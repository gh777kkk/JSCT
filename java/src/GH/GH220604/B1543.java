package GH.GH220604;

//        문제
//        세준이는 영어로만 이루어진 어떤 문서를 검색하는 함수를 만들려고 한다. 이 함수는 어떤 단어가 총 몇 번 등장하는지 세려고 한다. 그러나, 세준이의 함수는 중복되어 세는 것은 빼고 세야 한다. 예를 들어, 문서가 abababa이고, 그리고 찾으려는 단어가 ababa라면, 세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다. 그러나 동시에 셀 수는 없다.
//
//        세준이는 문서와 검색하려는 단어가 주어졌을 때, 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 문서가 주어진다. 문서의 길이는 최대 2500이다. 둘째 줄에 검색하고 싶은 단어가 주어진다. 이 길이는 최대 50이다. 문서와 단어는 알파벳 소문자와 공백으로 이루어져 있다.
//
//        출력
//        첫째 줄에 중복되지 않게 최대 몇 번 등장하는지 출력한다.

import java.io.*;
import java.util.StringTokenizer;

public class B1543 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int result = 0;

        String doc = br.readLine();
        String search = br.readLine();

        for (int i = 0; i < doc.length(); i++){
            if (i+search.length() > doc.length()) break;                    // 현재 idx + 검색 단어의 길이가 문서의 길이보다 크면 반복문 종료
            if (doc.charAt(i) == search.charAt(0)) {                        // 문서의 idx 번째 글자와 검색 단어의 첫글자가 맞으면 로직 실행 아니면 다음 idx
                if (doc.substring(i,i+search.length()).equals(search)) {    // 첫글자가 맞았을경우 단어 비교
                    result++;                                               // 검색단어와 맞으면 결과값 +1
                    i = i+search.length()-1;                                // 단어의 마지막 끝 idx 로 이동 -1 해주는 이유는 반복문의 종료 후 i 값의 1 증가 때문
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
