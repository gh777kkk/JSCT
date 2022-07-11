package algorithm.study._220604;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _14425문자열집합 {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer>hm=new HashMap<>();
		String[] str=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		
		int count=0;
		for(int i=0;i<n;i++) {
			String word=br.readLine();
			hm.put(word, 0);
		}
		for(int j=0;j<m;j++) {
			String testWord=br.readLine();
			if(hm.containsKey(testWord)) {
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}
