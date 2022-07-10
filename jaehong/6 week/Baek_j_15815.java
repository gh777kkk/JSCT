package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_j_15815 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String quest = br.readLine();

        int result = 0;
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        String str = "";

        for(int i = 0; i < quest.length(); i++){
            // 숫자면 스택에 담는다.
            if(quest.charAt(i) >= '0' && quest.charAt(i) <= '9'){
                stack.push(quest.charAt(i) - '0');
            }
            else {
                str += quest.charAt(i);
            }
 //           else {
//                if (cnt == 0) {
//                    int num_1 = stack.pop();
//                    int num_2 = stack.pop();
//                    result = operator(num_2, num_1, quest.charAt(i));
//                    cnt++;
//                }
//                else {
//                    int num = stack.pop();
//                    result = operator(num, result, quest.charAt(i));
//                }
//             }

        }
        System.out.println(str);

        for(int i = 0; i < str.length(); i++){

            // 부호가 나오면 스택에 들어있는 두 수를 꺼내와 연산 후 결과 값을 다시 스택에 담는다.
            int num1 = stack.pop();
            int num2 = stack.pop();
            result = operator(num2,num1,str.charAt(i));
            stack.push(result);

        }


        System.out.println(result);

    }

    public static int operator(int A, int B, char oper){

        int answer = 0;
        switch (oper){
            case '+' :
                answer = A + B;
                break;
            case '-' :
                answer = A - B;
                break;
            case '*' :
                answer = A * B;
                break;
            case '/' :
                answer = A / B;
                break;
        }
        return answer;
    }
}
