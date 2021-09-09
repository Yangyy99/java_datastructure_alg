package kmp;

/** @Author: 云萧YYY @DateTime: 2021/09/09 @Description: kmp 算法 */
public class KmpMatches {

  public static void main(String[] args) {

    String str = "abcabb";
    String dest = "ac";
    int[] next = next(str);
    System.out.println(matches(str, dest) == str.indexOf(dest));
  }

  /**
   * @param src 源字符串
   * @param dest 匹配字符串
   * @return index 索引位置
   */
  public static int matches(String src, String dest) {

    if (src == null || dest == null) {
      return -1;
    }
    int[] next = next(dest);
    int i = 0;
    int j = 0;
    while (i < src.length() && j < dest.length()) {

      if (src.charAt(i) == dest.charAt(j)) {
        j++;
        i++;
      } else {
        if (j == 0) {
          i++;
        } else {
          j = next[j - 1];
        }
      }
    }
    if (j == dest.length()) {
      return i - j;
    } else {
      return -1;
    }
  }

  /**
   * 获取匹配字串的next数组
   *
   * @param s
   * @return
   */
  private static int[] next(String s) {

    if (s == null || s.length() < 1) {
      throw new RuntimeException("参数不合法");
    }

    int[] next = new int[s.length()];
    next[0] = 0;
    for (int i = 1, j = 0; i < s.length(); i++) {

      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        // 回溯到之前的位置
        j = next[j - 1];
      }
      if (s.charAt(i) == s.charAt(j)) {
        j++;
      }
      next[i] = j;
    }
    return next;
  }
}
