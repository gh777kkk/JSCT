import java.util.Scanner;

public class B_1476 {
    public static void main(String[] args) {
        // 지구 E 태양 S 달 M ( 1 16 16 )

        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int ecnt = 1, scnt = 1, mcnt = 1;
        int year = 1;

        while(true){
            if(ecnt == E && scnt == S && mcnt == M){
                System.out.println(year);
                break;
            }
            ecnt++;
            if(ecnt > 15) ecnt = 1;
            scnt++;
            if(scnt > 28) scnt = 1;
            mcnt++;
            if(mcnt > 19) mcnt = 1;

            year++;
        }

    }
}

