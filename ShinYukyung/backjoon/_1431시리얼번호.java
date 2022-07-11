package algorithm.study._220604;

import java.util.*;
import java.io.*;
public class _1431시리얼번호 {

	public static void main(String[] args) throws IOException{
		//1. 길이 짧은게 먼저
		//2. 길이 같으면 자리수합 비교(숫자만)
		//3. 1,2번으로 비교할 수 없으면 사전순 비교. 숫자<알파벳
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(br.readLine());
		}
		list.sort(new Comparator<String>() {
			public int compare(String arg0,String arg1) {
				//길이 비교
				if(arg0.length()<arg1.length()) {
					return -1;
				}
				else if(arg0.length()==arg1.length()) {
					//cal함수로 숫자의 합 비교
					int v1=cal(arg0);
					int v2=cal(arg1);
					if(v1<v2) {
						return -1;
					}
					else if(v1==v2) {
						//arg0과 arg1의 사전적 순서 비교
						if(arg0.compareTo(arg1)<0)
							return -1;
						else
							return 1;
					}else
						return 1;
				}else
					return 1;
			}
		});
		
		for(String val:list) {
			System.out.println(val);
		}
	}
	
	//길이 같을 경우 숫자 더하는 함수
	private static int cal(String val) {
		int result=0;
		for(int i=0;i<val.length();i++) {
			if(val.charAt(i)>='0'&&val.charAt(i)<='9') {
				result+=val.charAt(i)-'0';
			}
		}
		return result;
	}

}
