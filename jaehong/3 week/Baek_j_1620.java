package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek_j_1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> p_list_1 = new HashMap<>();
        Map<Integer,String> p_list_2 = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            p_list_1.put(str,i);
            p_list_2.put(i,str);
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();

            if(str.charAt(0) > '0' && str.charAt(0) <= '9'){
                sb.append(p_list_2.get(Integer.parseInt(str))).append("\n");
            }
            else {
                sb.append(p_list_1.get(str)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
