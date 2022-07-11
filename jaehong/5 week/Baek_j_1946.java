package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_j_1946 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){

            int num = Integer.parseInt(br.readLine());
            int per[][] = new int[num][2];

            for(int j = 0; j < num; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 서류 심사 성적
                per[j][0] = Integer.parseInt(st.nextToken());
                // 면접 성적
                per[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(per, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            // 1등은 무조건 뽑힘.
            int cut = 1;

            // 비교 했을때 까지의 가장 작은 값.
            int prev = per[0][1];

            for(int j = 1; j < num; j++){
                // 서류 성적 순으로 정렬했으므로 면접 성적은 전에 비교 한 값보다 모두 작아야 한다.
                if(prev > per[j][1]){
                    prev = per[j][1];
                    cut++;
                }
//              1 4
//              2 3
//              3 2
//              4 1
//              5 5
            }


            System.out.println(cut);

        }
    }
}