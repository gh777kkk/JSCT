package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_j_18352 {
    public static ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    public static boolean vi[];
    public static int N;
    public static int de[];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 수
        N = Integer.parseInt(st.nextToken());
        // 도시에 연결 수
        int M =Integer.parseInt(st.nextToken());
        // 도시까지의 거리
        int target = Integer.parseInt(st.nextToken());
        // 출발 도시
        int start = Integer.parseInt(st.nextToken());

        vi = new boolean[N+1];
        // 해당 도시까지의 길이를 담는 배열
        de = new int[N+1];

        // 연결리스트에 노드 추가
        for(int i=0;i<=N;i++) {
            input.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int tempA = Integer.parseInt(st.nextToken());
            int tempB = Integer.parseInt(st.nextToken());
            input.get(tempA).add(tempB);
        }

        bfs(start);

        boolean check = false;
        for(int i = 1; i <= N; i++){
            if(de[i] == target) {
                System.out.println(i);
                check = true;
            }
        }
        if(!check) System.out.println(-1);



    }
    public static void bfs(int start){

        vi[start] = true;
        Queue<Integer> que = new LinkedList<>();

        que.add(start);

        while(!que.isEmpty()){
            int nowNode = que.poll();

            for(int i = 0; i < input.get(nowNode).size(); i++){

                int nextNode = input.get(nowNode).get(i);
                if(!vi[nextNode]) {
                    de[nextNode] = de[nowNode]+1;
                    vi[nextNode] = true;

                    que.add(nextNode);
                }
            }
        }
    }
}
