package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

    // 参考にした記事
		// Java8のラムダ式を理解する ※少しstreamの話も出てくる
		//   https://qiita.com/sano1202/items/64593e8e981e8d6439d3
		// Java Stream APIをいまさら入門
		//   https://qiita.com/takumi-n/items/369dd3fcb9ccb8fcfa44
		// Stream APIの特殊なメソッドとメソッド参照／コンストラクター参照
		//   https://atmarkit.itmedia.co.jp/ait/articles/1407/28/news023_2.html


		// 以下の文をStream APIを使ったかたちへと書き換える
		// すべての名前を大文字にしたリストを作り、そのリストを標準出力する。
		// 		List<String> nameList = new ArrayList<>(Arrays.asList("Kohlberg", "Kravis", "Roberts"));
		// 		List<String> upperNameList = new ArrayList<>();
		// 		for (String name : nameList) {
		// 			upperNameList.add(name.toUpperCase());
		// 		}
		// 		for (String name : upperNameList) {
		// 			System.out.println(name);
		// 		}

public class task1 {
  public static void main(String[] args){
    List<String> nameList = new ArrayList<>(Arrays.asList("Kohlberg", "Kravis", "Roberts"));
    Stream<Object> upperNameList = nameList.stream().map(s -> s.toUpperCase());
    upperNameList.forEach(s -> System.out.println(s));
  }
}
