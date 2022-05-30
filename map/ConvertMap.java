package map;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertMap {

  private Map<String, Map<String, Map<String, String>>> prefectures = new HashMap<>();
  private Map<String, Map<String, String>> municipalities = new HashMap<>();
  private Map<String, String> data = new HashMap<>();

  public Map<String, Map<String, Map<String, String>>> prefecturesCsvToMap(Path csvReadData) throws IOException {

    // 拡張for文でcsvデータをmapに格納するので、prefectureが切り替わったタイミングでprefectureを初期化する必要がある
    // そのために、1つ前のprefectureと現在のprefectureを比較するために変数を用意する
    String prepre = "都道府県名";

    try (Stream<String> s = Files.lines(csvReadData, Charset.forName("SJIS"))) {
      List<String> list = s.collect(Collectors.toList());

      for (String str : list) {
        String[] arr = str.split(",");
        int size = arr.length;

        // dataは必ず同じkeyを持っているので、後から入ってきたデータが全てのデータを上書きすることになる
        // それを防ぐために毎回初期化する
        data = new HashMap<>();

        // これがないと1つの県ごとに全ての市区町村データが格納される
        if (prepre.equals(arr[0]) == false) {
          municipalities = new HashMap<>();
        }
        prepre = arr[0];

        prefectures.put(arr[0], municipalities);
        municipalities.put(arr[1], data);
        data.put("人口", arr[2]);
        if (size == 4) {
          data.put("都道府県庁所在地", arr[3]);
        } else {
          data.put("都道府県庁所在地", "");
        }

      }
    }

    return prefectures;

  }
}
