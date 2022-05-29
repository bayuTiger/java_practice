package stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class task2 {
  public static void main(String[] args) {
    // 課題2. 以下の文を Stream API を使ったかたちへと書き換える
    // 80点以上の点数をとった人の名前のMapを作り、その名前と点数を標準出力する。
    // Map<String, Integer> scoreMap = new HashMap<String, Integer>() {
    // {
    // put("山田", 81);
    // put("鈴木", 78);
    // put("田中", 64);
    // put("佐藤", 97);
    // put("遠藤", 55);
    // }
    // };
    // Map<String, Integer> upperScoreMap = new HashMap<>();
    // for (Entry<String,Integer> entry : scoreMap.entrySet()) {
    // if (entry.getValue() >= 80) {
    // upperScoreMap.put(entry.getKey(), entry.getValue());
    // }
    // }
    // for (Entry<String, Integer> entry : upperScoreMap.entrySet()) {
    // System.out.println(entry.getKey() + ": " + entry.getValue() + "点");
    // }
    
    Map<String, Integer> scoreMap = new HashMap<String, Integer>() {
      {
        put("山田", 81);
        put("鈴木", 78);
        put("田中", 64);
        put("佐藤", 97);
        put("遠藤", 55);
      }
    };
    Stream<Object> upperScoreMap = scoreMap.entrySet().stream().filter(e -> e.getValue() >= 80)
        .map(e -> "キー名:" + e.getKey() + " 値:" + e.getValue());
    upperScoreMap.forEach(System.out::println);
  }
}
