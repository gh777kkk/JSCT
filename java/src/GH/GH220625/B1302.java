package GH.GH220625;

//        문제
//        김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
//
//        오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다. 둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
//
//        출력
//        첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.

import java.io.*;
import java.util.*;

public class B1302 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int max = 0;
        String result = "";

        for (int i = 0; i < n; i++){
            String book = br.readLine();
            map.merge(book, 1, Integer::sum);   // map 에 book 인 key 가 없으면 put(book,1) 있으면 기존 key 값 의 value + 1
        }

        for (String data : map.keySet()){
            if (max < map.get(data)){                   // 현재 가장 많은 수량의 책보다 더 많은 수량의 책이 들어오면 result 에 현재 책 값을 넣어준다.
                max = map.get(data);
                result = data;
            } else if (max == map.get(data) && data.compareTo(result) < 0) result = data;       // 만약 가장 많은 수량의 책과 동일한 수량이라면 알파벳 순 정렬을 해준다.
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
