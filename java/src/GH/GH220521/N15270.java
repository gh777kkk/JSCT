package GH.GH220521;

//        문제
//        초등학생인 재홍이는 이번 봄 학예회 때, 재홍이가 지휘를 맡고 반 친구들이 춤을 추기로 계획했다. 이 춤은 시작할 때 춤추는 친구들이 일렬로 쭉 서서 각자 막춤을 추다가, 가운데 있는 친구를 기준으로 왼쪽과 오른쪽에 있던 친구들이 두손을 마주잡고 춤을 춘다. 즉 5명의 친구가 일렬로 서있었다면, 첫 번째 친구와 다섯 번째 친구가 함께 춤을 추게 되며, 두 번째 친구와 네 번째 친구가 함께 춤을 추게 된다. 세 번째에 있던 친구는 같이 출 수 있는 친구가 없기 때문에 혼자 로봇 댄스를 춘다.
//
//        재홍이네 반 친구들은 모두 자신과 친한 친구하고만 춤을 추고 싶어한다. 재홍이는 이번 학예회에 스케일 크게 해보고 싶기 때문에 최대한 많은 친구를 무대에 세우려고 한다. 친구 관계도가 주어졌을 때, 최대 몇 명을 무대로 올려보낼 수 있는지 구해서 재홍이에게 알려주자. 친구들은 출석번호로 나타내며, 1부터 시작해서 N까지 있다. 각 친구는 오로지 하나의 출석번호를 갖는다.
//
//        A와 B가 친한 친구고, B와 C가 친한 친구라고해서 반드시 A와 C가 친한 친구는 아니다. 로봇 댄스를 추는 친구를 제외한 무대에 올라가는 친구들은 모두 각자 자신과 친한 친구하고만 춤을 춰야한다. 또한 재홍이 반 친구들은 모두 로봇 댄스를 출 수 있다.
//
//
//
//        입력
//        첫째 줄에 총 반친구 수 N(2<=N<=20, 재홍이 제외)와 관계도 수 M(0<=M<=(N^2-N)/2, 최대 50 제한)이 주어진다. 둘째 줄부터 M+1줄까지 친한 친구 관계는 출석번호 u, v로 나타나며 u와 v는 같지 않고, u와 v가 친한 친구라면 v와 u도 친한 친구다.
//
//        똑같은 입력은 두 번 이상 나오지 않는다. 가령 1 2 가 이미 나왔다면 1 2 또는 2 1는 입력으로 들어오지 않는다.
//
//        출력
//        무대에 최대한 세울 수 있는 친구의 수를 출력한다.


/*
* 5 3
* 1 2
* 2 3
* 1 4
* 5
*
* 5 3
* 1 2
* 1 3
* 1 4
* 3
*
* */

import java.io.*;
import java.util.StringTokenizer;

public class N15270 {

    private static int[][] f;           //친구관계
    private static int result;          //결과값
    private static int m;               //관계수
    private static boolean[] check;     //확인 체크

    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //학생 수
        m = Integer.parseInt(st.nextToken());

        f = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            f[i][0] = Integer.parseInt(st.nextToken());
            f[i][1] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[n+1];
        dfs(0,0);

        result *= 2;
        if (result < n) result++;

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int idx, int cnt){
        if(idx >= m) {
            result = Math.max(result, cnt);
            return;
        }
        if (check[f[idx][0]] || check[f[idx][1]]) {     // 1명이라도 체크 안했을때
            dfs(idx+1, cnt);
        } else {
            check[f[idx][0]] = true;
            check[f[idx][1]] = true;

            dfs(idx + 1, cnt + 1);

            check[f[idx][0]] = false;
            check[f[idx][1]] = false;

            dfs(idx + 1, cnt);
        }
    }
}
