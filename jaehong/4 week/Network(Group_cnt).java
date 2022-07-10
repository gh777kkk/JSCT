
package DFS_BFS;

//dfs 그룹 개수 구하기
public class Group_cnt {

    public static void main(String[] args) {

        int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        boolean visited[] = new boolean[computers.length];

        int answer = 0;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i,visited,computers);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, boolean visited[] ,int computers[][]) {
        visited[x] = true;

        for (int i = 0; i < computers[x].length; i++) {
            if (computers[x][i] == 1 && !visited[i]) {
                dfs(i,visited,computers);
            }
        }
    }
}

