package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_j_5635 {

    public static String[] name;
    public static int[][] age;

    public static int[] minAge;
    public static int[] maxAge;
    public static String minName;
    public static String maxName;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        name = new String[N];
        age = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            age[i][2] = Integer.parseInt(st.nextToken());
            age[i][1] = Integer.parseInt(st.nextToken());
            age[i][0] = Integer.parseInt(st.nextToken());
        }
        br.close();

        minAge = age[0];
        maxAge = age[0];
        minName = name[0];
        maxName = name[0];

        for(int i = 1; i < N; i++){
            minCheck(i,0);
            maxCheck(i,0);
        }
        System.out.print(minName + '\n' + maxName);
    }

    public static void minCheck(int i, int x){

        // 태어난 날이 전부 다르다는 조건있으므로 필요없는 문장
        if(x > 2) return;

        if(minAge[x] < age[i][x]){
            minAge = age[i];
            minName = name[i];
        }
        else if(minAge[x] == age[i][x]){
            // 연도가 같다면 월 비교 -> 월이 같다면 일 비교
            minCheck(i,x+1);
        }

    }

    public static void maxCheck(int i, int x){

        if(x > 2) return;

        if(maxAge[x] > age[i][x]){
            maxAge = age[i];
            maxName = name[i];
        }
        else if(maxAge[x] == age[i][x]){
            maxCheck(i,x+1);
        }
    }
}
