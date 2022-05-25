package FunctionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

		// 仕様
		// - 関数名は partition とする
		// - 第一引数に int型 をとり、これを分割する基準の数とする。
		// - 第二引数に List<T> をとる。このリストについて分割をおこなう。
		// - 戻り値の型は List<List<T>> とする。
		// - 第一引数に 1 未満の値を指定した場合は 空 のリストを返却する。
		// - 関数使用例
		//   partition(1, ["a", "b", "c", "d"]) → [["a"], ["b"], ["c"], ["d"]]
		//   partition(2, ["a", "b", "c", "d"]) → [["a", "b"], ["c", "d"]]
		//   partition(3, ["a", "b", "c", "d"]) → [["a", "b", "c"], ["d"]]
		// - 以下のコード実行時に例外が発生しない
		//      ジェネリクスについて参考にした記事：https://qiita.com/taumax/items/2af451a2c331e8ded892
		//		参考動画(YouTube):https://www.youtube.com/watch?v=_VKCSaN-fqs&list=PL0BiAlg8j4ZtYGreByAsE11OMehHGjjq8
		//      ジェネリクスメソッドの定義方法について参考にした記事：https://qiita.com/rodentia6/items/b36d134fa24867ba4d63

public class prac5 {
  public static void main(String[] args){
		List<List<String>> part = partition(2, Arrays.asList("a", "b", "c", "d"));
		assert part.size() == 2;
		assert part.get(0).equals(Arrays.asList("a", "b"));
		assert part.get(1).equals(Arrays.asList("c", "d"));

		part = partition(1, Arrays.asList("a", "b", "c", "d"));
		assert part.size() == 4;
		assert part.get(0).equals(Arrays.asList("a"));
		assert part.get(1).equals(Arrays.asList("b"));
		assert part.get(2).equals(Arrays.asList("c"));
		assert part.get(3).equals(Arrays.asList("d"));

		part = partition(2, Arrays.asList("a", "b", "c", "d", "e"));
		assert part.size() == 3;
		assert part.get(0).equals(Arrays.asList("a", "b"));
		assert part.get(1).equals(Arrays.asList("c", "d"));
		assert part.get(2).equals(Arrays.asList("e"));

		part = partition(0, Arrays.asList("a", "b"));
		assert part.size() == 0;

		part = partition(-1, Arrays.asList("a", "b"));
		assert part.size() == 0;
		
		List<List<Integer>> intPart = partition(2, Arrays.asList(1, 2, 3, 4));
		assert intPart.size() == 2;
		assert intPart.get(0).equals(Arrays.asList(1, 2));
		assert intPart.get(1).equals(Arrays.asList(3, 4));
  }
    
  private static <T> List<List<T>> partition(int i ,List<T> list){
    List<List<T>> partitionList = new ArrayList<>();
    System.out.println(list);
    int endIndex = 0;
    if(i < 1){
      return partitionList;
    }
    for (int j = 0; j < list.size(); j += i) {
        if(i + j > list.size()){
          endIndex = list.size();
        }else{
          endIndex = j + i;
        }
        List<T> subList = list.subList(j , endIndex);
        System.out.println(subList);
        partitionList.add(subList);
    }
    System.out.println(partitionList);
    return partitionList;
  }
}
