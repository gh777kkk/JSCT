package GH.GH220521.프로그래머스;

public class 타겟넘버 {
    static int result;
    public static void main (String[] arg){
        int[] n = {1, 1, 1, 1, 1};
        System.out.print(solution(n,3));
    }

    private static int solution(int[] numbers, int target){
        dfs(numbers,target,0,0);
        return result;
    }

    // idx 배열의 번호 , sum idx의 합계
    private static void dfs (int[] n, int target, int idx, int sum){
        if (idx >= n.length){
            if (sum == target) result++;
            return;
        }

        int add = sum + n[idx];
        dfs (n, target, idx+1, add); // 각 배열 idx 를 + 로 가정하고 계산

        int sub = sum - n[idx];
        dfs (n, target, idx+1, sub); // 각 배열 idx 를 - 로 가정하고 계산
    }
}
