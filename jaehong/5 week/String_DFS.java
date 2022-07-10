package DFS_BFS;

public class String_DFS {

    public static int answer = 0;
    public static boolean vi[];
    public int solution(String begin, String target, String[] words) {

        vi = new boolean[words.length];

        dfs(begin,target,words,0);

        return answer;
    }

    public static void dfs(String begin,String target,String[] words,int cnt){

        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(vi[i]){
                continue;
            }

            int leng = 0;
            for(int j = 0; j <begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    leng++;
                }
            }
            if(leng == begin.length()-1){
                vi[i] = true;
                dfs(words[i],target,words,cnt+1);
                vi[i] = false;
            }
        }
    }
}


//class Solution {
//    public int solution(int[] nums) {
//        int answer = 0;
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    int sum = nums[i] + nums[j] + nums[k];
//
//                    if (prime(sum)) {
//                        answer++;
//                    }
//                }
//            }
//        }
//
//        return answer;
//    }

//    public static boolean prime(int N){
//        if(N == 0){
//            return false;
//        }
//        if(N == 1){
//            return false;
//        }
//        for(int i = 2; i <= Math.sqrt(N); i++){
//            if(N%i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
//}