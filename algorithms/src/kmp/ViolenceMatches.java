package kmp;

/** @Author: 云萧YYY @DateTime: 2021/09/08 @Description: 字符串暴力匹配 */
public class ViolenceMatches {

  public static void main(String[] args) {
    //
      String str1="aaaaaaab";
      String str2="aaab ";

    System.out.println(math(str1, str2));
    System.out.println(str1.indexOf(str2));
  }

  /**
   * 在s1中查找是否含有s2字符串
   *
   * @param s1 原字符串
   * @param s2 匹配的字符串
   * @return 返回索引
   */
  public static int math(String str1, String str2) {

    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();

    int i = 0;
    int j = 0;
    while (i < s1.length && j < s2.length) {

      if (s1[i] == s2[j]) {
        i++;
        j++;
      } else {
        i = i - (j - 1);
        j = 0;
      }
    }
    if (j == s2.length) {
      return i - j;
    } else {
      return -1;
    }
  }
}
