package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_j_5635_collection {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<String>> nameAge = new ArrayList<>();

        for(int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> temp = new ArrayList<>();

            temp.add(st.nextToken());

            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());


            temp.add(String.valueOf(((year-1990) *365) + (month*30) + day));

            nameAge.add(temp);
        }


        Collections.sort(nameAge, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return Integer.parseInt(o1.get(1)) - Integer.parseInt(o2.get(1));
            }
        });


        System.out.println(nameAge.get(N-1).get(0) + '\n' + nameAge.get(0).get(0));
    }

}
