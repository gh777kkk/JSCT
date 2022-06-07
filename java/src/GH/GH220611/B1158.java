package GH.GH220611;

//        문제
//        요세푸스 문제는 다음과 같다.
//
//        1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
//
//        N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
//
//        출력
//        예제와 같이 요세푸스 순열을 출력한다.

import java.io.*;
import java.util.*;

public class B1158 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            list.add(i+1);
        }
        sb.append('<');

        while (list.size() > 0){
            --cnt;          // 최초 배열의 idx 와 숫자값의 일치시키기 위해서 그다음 반복문 부터는 삭제되는 idx 때문에
            cnt += k;       // 다음 제거되는 idx 를 찾는다
            while (cnt >= list.size()) cnt = cnt - list.size();                 // 만약 idx 가 현재 배열의 숫자보다 크면 작을때까지 list 의 크기만큼 빼준다.
            if(list.size() != 1) sb.append(list.remove(cnt)).append(", ");      // list 에서 현재 idx 를 빼주고 출력 값에 넣어준다.
            else sb.append(list.remove(cnt));
        }

        sb.append('>');
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
