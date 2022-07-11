package Algorithm;

import java.util.Scanner;

public class Baek_j_2839 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        // 3과 5의 조합으로 나올수 없는 수
        if(N<5 && N != 3 || N ==7)
            System.out.print(-1);
        else {
            // 5를 가장 많이 써야 최소 값이 되므로 5부터 반복문을 돌린다.
            for(int i = 0; i <= N/3; i++){
                for(int j =0; j <= N/5; j++){
                    if( N == (i*3) + (j*5)) {
                        System.out.print(i + j);
                        return;
                    }
                }
            }
        }
    }
}
