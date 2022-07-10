package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_j_1431 {
    static String[] strArr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        strArr = new String[N];

        for(int i = 0; i < N; i++){
            strArr[i] = br.readLine();
        }

        int i = 0;
        while(i < N-1){

            // 현재 위치의 길이보다 다음 위치의 길이가 크면 트레이드 X, i 값만 증가 시킨후 다음 위치 비교
            if(strArr[i].length() < strArr[i+1].length()){
                i++;
            }

            // 현재 위치의 길이보다 다음 위치의 길이가 작다면 트레이드 O
            else if(strArr[i].length() > strArr[i+1].length()){
                // 트레이드 함수 호출후, 다시 처음부터 비교
                change(i);
                i = 0;
            }
            // 길이가 같다면 체크 함수를 호출해 트레이드 여부 판단
            else {
                if(check(strArr[i],strArr[i+1])){
                    change(i);
                    i = 0;
                    continue;
                }
                // 트레이드가 이루워 지지 않는다면 i값을 증가
                i++;
            }
        }

        for(int j = 0 ; j < N; j++){
            System.out.println(strArr[j]);
        }
    }

    // 두 문자열의 길이가 같을 때  위치를 트레이드 여부(true: O, false: X) 체크하는 함수
    // A는 현재 위치 문자 B 비교 위치 문자
    public static boolean check(String A, String B){

        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < A.length(); i++) {
            // 문자의 char중 숫자가 있으면 다 더한다.
            if (A.charAt(i) <= '9' && A.charAt(i) >= '0') {
                sumA += A.charAt(i) - '0';
            }

            if (B.charAt(i) <= '9' && B.charAt(i) >= '0') {
                sumB += B.charAt(i) - '0';
            }
        }

        // 더한 값이 현재위치가 더 크면 트레이드
        if(sumA > sumB) return true;
        // 더한 값이 같으면 사전 순으로 비교
        else if( sumA == sumB ){
            for(int i = 0; i < A.length(); i++){
                if(A.charAt(i) > B.charAt(i)) return true;
                else if(A.charAt(i) <B.charAt(i)) return false;
            }
        }

        // 모두 해당 되지 않는 다면 트레이드 X
        return false;
    }

    // 트레이드 함수
    public static void change(int i){
        String temp = strArr[i];
        strArr[i] = strArr[i+1];
        strArr[i+1] = temp;
    }

}
