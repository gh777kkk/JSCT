package GH.GH220618;

//        입력
//        첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져. N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수인데, 자연수가 뭔지는 알지? 모르면 물어봐도 괜찮아. 나는 언제든지 질문에 답해줄 준비가 되어있어.
//
//        둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와. 포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어. 아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어. 포켓몬 이름의 최대 길이는 20, 최소 길이는 2야. 그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와. 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해. 입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져. 그럼 화이팅!!!
//
//        출력
//        첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!. 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] list = new String[n+1];
        HashMap<String , Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++){
            list[i] = br.readLine();    // 포켓몬 이름을 list 에 담는다.
            map.put(list[i],i);         // idx 를 map 에 담는다.
        }

        for (int i = 0; i < m; i++){
            String temp = br.readLine();
            if ( temp.charAt(0) >= 65 && temp.charAt(0) <=90 ) sb.append(map.get(temp)).append('\n');       // 최초 첫글자가 A ~ Z 가 들어오면 포켓몬의 이름으로 map 에서 idx 를 꺼내준다.
//            for (int j = 1; j <= n; j++){             //최초 코드 시간초과로 인해 HashMap 사용
//                if (temp.equals(list[j])) {
//                    sb.append(j).append('\n');
//                    break;
//                }
//            }
            else sb.append(list[Integer.parseInt(temp)]).append('\n');                                      // 최초 첫글자가 A ~ Z 가 아니면 무조건 숫자다 리스트에 담긴 포켓몬 이름을 꺼내준다.
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
