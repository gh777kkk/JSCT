import java.util.*;

class Max_node {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        int max = 0;

        int map[][] = new int[n][n];

        for(int i = 0; i < edge.length; i++){
            int x = edge[i][0]-1;
            int y = edge[i][1]-1;

            map[x][y] = 1;
            map[y][x] = 1;
        }

        boolean vi[] = new boolean[n];
        int cut[] = new int[n];


        cut = bfs(0,vi,cut,map);

        for(int i = 0; i < n; i++){
            if(max < cut[i]){
                max = cut[i];
                answer = 1;
            }
            else if(max == cut[i]){
                answer++;
            }
        }

        return answer;
    }

    public static int[] bfs(int start,boolean vi[],int cut[],int map[][]){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vi[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i = 0; i < map.length; i++){
                if(map[x][i] != 0 && !vi[i]){
                    vi[i] = true;
                    cut[i] = cut[x] + map[x][i];
                    q.offer(i);
                }
            }
        }
        return cut;
    }
}