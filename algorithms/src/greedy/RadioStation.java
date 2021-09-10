package greedy;

import java.util.*;

/**
 * @Author: 云萧YYY @DateTime: 2021/09/10 @Description: 贪心算法 解决广播站问题
 * ，现在有以下几个广播站，每个广播站覆盖的城市不同，问如何选取广播站可以覆盖全部城市
 */
public class RadioStation {

  public static void main(String[] args) {

    // 广播站 覆盖城市表
    Map<String, HashSet<String>> broadcast = new HashMap<>();
    //
    init(broadcast);
    // 要覆盖的城市
    HashSet<String> allArea = new HashSet<>();
    for (Map.Entry<String, HashSet<String>> entry : broadcast.entrySet()) {
      allArea.addAll(entry.getValue());
    }

    ArrayList<String> radioStations = greedRadioStation(broadcast, allArea);

    System.out.println(radioStations);
  }

  public static ArrayList<String> greedRadioStation(
      Map<String, HashSet<String>> broadcast, HashSet<String> area) {

    ArrayList<String> radio = new ArrayList<>();
    String maxKey = null;
    HashSet<String> set = null;

    // 找出来一个 广播站 可以覆盖最多城市的站口
    while (!area.isEmpty()) {

      for (Map.Entry<String, HashSet<String>> entry : broadcast.entrySet()) {

        set = new HashSet<>();
        set.addAll(entry.getValue());
        // 取交集与area的集合
        set.retainAll(area);
        /** maxKey 记录当前表示最大的覆盖城市的广播*/
        if (set.size() > 0 && (maxKey == null || broadcast.get(maxKey).size() < set.size())) {
          maxKey = entry.getKey();
        }
      }
      area.removeAll(broadcast.get(maxKey));
      radio.add(maxKey);
      maxKey = null;
    }
    return radio;
  }

  /**
   * 初始化广播站表
   *
   * @param broadcast
   */
  public static void init(Map<String, HashSet<String>> broadcast) {
    HashSet<String> set = new HashSet<>();
    set.add("北京");
    set.add("上海");
    set.add("天津");
    broadcast.put("k1", set);

    HashSet<String> set1 = new HashSet<>();
    set1.add("广州");
    set1.add("北京");
    set1.add("深圳");
    broadcast.put("k2", set1);

    HashSet<String> set2 = new HashSet<String>();
    set2.add("成都");
    set2.add("上海");
    set2.add("杭州");
    broadcast.put("k3", set2);

    HashSet<String> set3 = new HashSet<>();
    set3.add("上海");
    set3.add("天津");
    broadcast.put("k4", set3);

    HashSet<String> set4 = new HashSet<>();
    set4.add("杭州");
    set4.add("大连");
    broadcast.put("k5", set4);
  }
}
