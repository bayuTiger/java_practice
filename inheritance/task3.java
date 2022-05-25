package inheritance;

import java.util.ArrayList;

// ArrayList<T>クラスを継承したAutoSortedList<T>クラスを作成
// boolean add(T e)、void add(int index, T element)の２つのメソッドをオーバーライドし、
// add実行の度にリストの中身がソートされるように機能を追加

public class task3 {

  public class AutoSortedList<T> extends ArrayList<T> {
    ArrayList<T> arr = new ArrayList<T>();

    public AutoSortedList() {
    };

    @Override
    public boolean add(T e) {
      arr.add(e);
      return true;
    }

    @Override
    public void add(int index, T element) {
      arr.add(index, element);
      arr.sort(null);
    }
  }
}
