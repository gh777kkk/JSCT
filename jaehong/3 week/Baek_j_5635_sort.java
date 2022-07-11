package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_j_5635_sort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String nameAge[][] = new String[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            nameAge[i][0] = st.nextToken();

            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            nameAge[i][1] = String.valueOf(((year-1990) *372) + (month*31) + day);

        }

        Arrays.sort(nameAge,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });

        // 일수가 클수록 나이가 적다
        System.out.print( nameAge[N-1][0] + '\n' + nameAge[0][0] );
    }
}
