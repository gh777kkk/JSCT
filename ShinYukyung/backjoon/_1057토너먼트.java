package algorithm.study._220604;

import java.io.*;
import java.util.*;
public class _1057토너먼트 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int jimin = sc.nextInt();
    	int hansu = sc.nextInt();
    	int cnt = 1;
    	while(true) {
    		if((jimin%2==0 && jimin-hansu==1) || (hansu%2==0 && hansu-jimin==1)) 
    			break;
    		
    		if(jimin%2==0)
        		jimin /= 2;
        	else
        		jimin = jimin/2 +1;
        	
        	if(hansu%2==0)
        		hansu /= 2;
        	else
        		hansu = hansu/2 +1;
        	
        	cnt++;	
    	}
    	System.out.println(cnt);
    }
}