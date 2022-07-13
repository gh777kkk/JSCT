package GH.GH220716;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B16401 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Long> l = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            l.add(Long.parseLong(st.nextToken()));
        }

        while (true){
            Collections.sort(l);
            long max = l.get(l.size()-1);
            l.remove(l.size()-1);
            l.add(max/2);
            l.add(max/2);
            if (l.size() >= m && l.get(l.size()-m) >= max/2) break;
        }

        Collections.sort(l);

        sb.append(l.get(l.size()-m));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
