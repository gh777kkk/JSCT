import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_Dfs_1260 {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 정점의 개수
    int m = sc.nextInt(); // 간선의 개수
    int v = sc.nextInt(); // 탐색 시작 번호

    int[][] node = new int[n+1][n+1];
    boolean[] visited = new boolean[n+1];

    // 연결 노드 업데이트하기
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 양쪽으로 간선 잇기
        node[a][b] = 1;
        node[b][a] = 1;
    }

    dfs(node, visited, n, v);
    System.out.println();

    //bfs print
    visited = new boolean[n+1];
    bfs(node, visited, n, v);
  }

  public static void dfs (int[][] node, boolean[] visited, int n, int v) {
    visited[v] = true; //first node

    for (int i = 1; i < n + 1; i++) {
      if (node[v][i] == 1 && !visited[i]) {
        System.out.print(v + " ");
        dfs(node, visited, n, i);
      }
    }
  }

  public static void bfs(int[][] node, boolean[] visited, int n, int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int temp = queue.poll();

      for (int i = 1; i < n + 1; i++) {
        if (node[temp][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
          System.out.print(i + " ");
        }
      }
    }
  }
}
