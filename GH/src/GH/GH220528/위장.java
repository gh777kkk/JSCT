package GH.GH220528;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class 위장 {
    public static void main (String[] arg){
        String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.print(solution(clothes));
    }

    private static int solution(String[][] clothes){
        List<String> one = new ArrayList<>();
        HashSet<String> kinds = new HashSet<>();
        for (String[] clothe : clothes) {
            kinds.add(clothe[1]);
            one.add(clothe[1]);
        }

        ArrayList<String> kindsOut = new ArrayList<>(kinds);
        int result = 1;

        for (int i = 0; i < kinds.size(); i++){
            result *= Collections.frequency(one, kindsOut.get(i)) + 1;
        }

        return result-1;
    }
}
