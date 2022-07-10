package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_j_5635_total {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] name = new String[N];
        int[] age = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            // 연,월을 일수로 비교해서 계산.
            age[i] = ((year-1990) *365) + (month*30) + day;
        }
        br.close();

        int minAge = age[0];
        int maxAge = age[0];
        String minName = name[0];
        String maxName = name[0];

        for(int i = 1; i < N; i++){

            if(minAge < age[i]){
                minAge = age[i];
                minName = name[i];
            }

            if(maxAge > age[i]){
                maxAge = age[i];
                maxName = name[i];
            }
        }
        System.out.print(minName + '\n' + maxName);
    }

}
