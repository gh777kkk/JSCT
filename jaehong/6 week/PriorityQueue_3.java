package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueue_3 {

    public static void main(String[] args){
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

        String input[] = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"} ;

        for(int i = 0; i < input.length; i++){
            StringTokenizer st = new StringTokenizer(input[i]);
            String check = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(check.equals("I")){
                minQue.add(num);
                maxQue.add(num);
            }
            else{
                if(num == 1){
                    maxQue.poll(); // 333 97 45 -45 -64
                    if(maxQue.isEmpty()) minQue.clear();
                }
                else{
                    minQue.poll();// -45 45 97 333 653
                    if(minQue.isEmpty()) maxQue.clear();
                }
            }
        }

        int max = 0;
        int min = 0;
        while (!maxQue.isEmpty()){
            int maxTemp = maxQue.peek();

            if(minQue.contains(maxTemp)){
                max = maxTemp;
                break;
            }
            maxQue.poll();
        }

        while (!minQue.isEmpty()){
            int minTemp = minQue.peek();

            if(max == min){
                min = max;
                break;
            }
            else if(maxQue.contains(minTemp)){
                min = minTemp;
                break;
            }
            minQue.poll();
        }

        System.out.println(max + " " + min);

    }
}
