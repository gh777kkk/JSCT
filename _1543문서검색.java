package algorithm.study._220604;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1543문서검색 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String document=br.readLine();
		String search=br.readLine();
		
		int find=0;
		int count=0;
		
		while(find<document.length()) {
			String copy="";
			if(find + search.length()<=document.length()) {
				copy=document.substring(find,find+search.length());
			}
			if(search.equals(copy)) {
				find+=search.length();
				count++;
			}
			else {
				find++;
			}
		}
		System.out.println(count);

	}
}
