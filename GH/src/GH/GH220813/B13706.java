package GH.GH220813;

import java.io.*;
import java.math.BigInteger;

public class B13706 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //  큰숫자 사용하기 위해서 BigInteger 사용 문자열로 담아서 거의 무한대 자릿수 가능
        //  4측연산 함수 add(), subtract(), multiply(), divide() 나머지는 remainder()
        //  형 변환 intValue() , longValue(), floatValue() , doubleValue() , toString()
        //  비교 num1.compareTo(num2) 0 : num1 = num2 , 1 : num1 > num2 , -1 : num1 < num2
        BigInteger n = new BigInteger(br.readLine());
        BigInteger s = BigInteger.ONE;
        BigInteger end = n;
        BigInteger result;

        while (true){
            result = s.add(end);
            result = result.divide(new BigInteger("2"));

            int temp = result.multiply(result).compareTo(n);
            if (temp == 0) break;
            else if (temp > 0) end = result.subtract(new BigInteger("1"));
            else s = result.add(new BigInteger("1"));
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
