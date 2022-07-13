package GH.GH220709;

//        문제
//        평행 세계의 성필은 숫자와 연산자를 만든 당대 최고의 수학자이다. 그리고 놀랍게도 이 숫자와 연산자는 현재 우리가 사용하는 것과 같다. 하지만 수식은 연산자가 피연산자 가운데 위치하는 우리와는 다르게 연산자가 피연산자 뒤에 위치한다고 한다.
//
//        우리 세계의 식을 성필의 식으로 바꾸는 방법을 간단히 설명하자면 이렇다. 우선 주어진 식을 연산자의 우선순위에 따라 괄호로 묶어준다. 그런 다음에 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨주면 된다.
//
//        예를 들어 a+b*c는 (a+(b*c))의 식과 같게 된다. 그다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 a+bc*가 된다. 마지막으로 또 +를 괄호의 오른쪽으로 고치면 abc*+가 되게 된다.
//
//        천재 수학자 성필은 자신이 만든 이런 간단한 식조차 1초 안에 계산하지 못하는 사람들을 위하여 답을 구해주는 프로그램을 개발하려고 했지만 아쉽게도 성필의 세계에는 프로그래밍 언어가 없다. 프로그래밍을 할 수 있는 우리가 성필을 위해 평행세계의 식을 계산하는 프로그램을 만들어주자.
//
//        입력
//        길이가 100이 넘지 않는 수식이 예제 입력과 같이 공백 없이 입력된다. 수식은 0부터 9까지의 숫자와 연산자 '+', '-', '*', '/' 로만 이루어져 있다.
//
//        또한, 수식의 계산 중간 과정의 모든 결과는 항상 2,147,483,647을 넘지 않는 정수이고 0으로 나누는 경우는 없습니다.
//
//        잘못된 수식이 입력되는 경우도 없습니다.
//
//        출력
//        입력으로 주어진 성필의 수식의 답을 첫째 줄에 출력한다.

import java.io.*;
import java.util.StringTokenizer;

public class B1182 {

    private static int[] list;
    private static int n;
    private static int s;
    private static int result = 0;

    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        if (s == 0) result--;

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int idx, int sum){
        if (idx >= n){
            if (sum == s) result++;
            return;
        }

        dfs(idx + 1 , sum + list[idx]);
        dfs(idx + 1 , sum);
    }
}