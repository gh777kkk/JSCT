package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_j_14235_timeout {

    public static Stack<Integer> stack;
    public static Stack<Integer> stack_tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 선물을 받는 자료구조
        stack = new Stack<>();
        stack_tmp = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 거점을 방문했는지 아이들에게 방문했는지 체크
            int check = Integer.parseInt(st.nextToken());

            if(check != 0){

                for(int j = 0; j < check; j++){
                    int pv = Integer.parseInt(st.nextToken());
                    stackIndex(pv);
                }
            }
            else {
                if(stack.empty()) sb.append(-1).append('\n');
                else sb.append(stack.pop()).append('\n');
            }
        }

        System.out.print(sb.toString());

    }
    public static void stackIndex(int pv){


        while(!stack.empty()){
            if( stack.peek() > pv ){
                stack_tmp.push(stack.pop());
            }
            else {
                break;
            }
        }
        stack.push(pv);

        while (!stack_tmp.empty()){
            stack.push(stack_tmp.pop());
        }


    }

}
