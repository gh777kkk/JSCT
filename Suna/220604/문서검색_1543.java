import java.util.Scanner;

/**
 *  완전탐색
 *
 *  방식
 *  1. document 와 word 만큼 탐색
 *  2. replaceAll 을 이용해 replace 된것에 대한 count
 */
public class 문서검색_1543 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String document = sc.nextLine();
    String word = sc.nextLine();

    int duplicate = 0;
    boolean match = false;
    int charCount = 0;

    while (charCount < document.length()) {
      for (int j = 0; j < word.length(); j++) {

        if (charCount + j >= document.length()) {
          charCount += j;
          break;
        }

        if (document.charAt(charCount + j) == word.charAt(j)) {
          match = true;
        } else {
          match = false;
          charCount++;
          break;
        }
        if (j == word.length() - 1) {
          duplicate++;
          charCount += j + 1;
        }
      }
    }

    System.out.println(duplicate);
  }

  /**
   * replaceAll 을 이용해서 반복문 확인
   *
   * @param document
   * @param word
   */
  public static void replaceWithWord(String document, String word) {

    int count = 0;

    document = document.replaceAll(word, "1");

    for (int i = 0; i < document.length(); i++) {
      if (document.charAt(i) == '1') count++;
    }

    System.out.println(count);
  }
}
