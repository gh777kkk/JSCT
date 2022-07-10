package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_j_1543 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = br.readLine();
        String searchStr = br.readLine();

        int cnt = 0;

        // 비교를 해야될 위치
        int i = 0;

        // 비교해야한 위치(i)에서 전체길이 까지 남을 길이가 (targetStr - i) 검색해야할 문자(searchStr)의 길이보다 짧으면 포함되는게 없음.
        while (i < targetStr.length()-searchStr.length()+1){

            for(int j = 0; j < searchStr.length(); j++,i++){
                // i 위치에서부터 시작된 문자가 searchStr와 같지 않다면 시작 위치 +1 부터 비교.
                if(searchStr.charAt(j) != targetStr.charAt(i)){
                    i = i - j + 1;
                    break;
                }
                // 끝까지 비교 했을때까지 같다면 count 값 증가.
                else if(j == searchStr.length()-1){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
