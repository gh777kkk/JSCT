package GH.GH220618;

//        문제
//        어떤 반에 있는 학생들의 생일이 주어졌을 때, 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 반에 있는 학생의 수 n이 주어진다. (1 ≤ n ≤ 100)
//
//        다음 n개 줄에는 각 학생의 이름과 생일이 "이름 dd mm yyyy"와 같은 형식으로 주어진다. 이름은 그 학생의 이름이며, 최대 15글자로 이루어져 있다. dd mm yyyy는 생일 일, 월, 연도이다. (1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1 ≤ dd ≤ 31) 주어지는 생일은 올바른 날짜이며, 연, 월 일은 0으로 시작하지 않는다.
//
//        이름이 같거나, 생일이 같은 사람은 없다.
//
//        출력
//        첫째 줄에 가장 나이가 적은 사람의 이름, 둘째 줄에 가장 나이가 많은 사람 이름을 출력한다.

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B5635 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        LocalDate max = LocalDate.of(1000,1,1);
        LocalDate min = LocalDate.of(3000,12,31);
        String max_name = "";
        String min_name = "";

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            if(max.isBefore(LocalDate.of(year,month,day))) {        // max 보다 LocalDate.of(year,month,day) 크면 max_name 을 갱신
                max = LocalDate.of(year,month,day);
                max_name = name;
            }
            if(min.isAfter(LocalDate.of(year,month,day))) {        // min 보다 LocalDate.of(year,month,day) 적으면 min_name 을 갱신
                min = LocalDate.of(year,month,day);
                min_name = name;
            }
        }
        sb.append(max_name).append('\n');
        sb.append(min_name).append('\n');

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
