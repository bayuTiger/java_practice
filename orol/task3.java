package orol;

// Employee クラスについて、親クラスに定義されている introduceStatement() メソッドをオーバーライドして、戻り値が以下のようになるようにせよ。
// 私の名前は{名字} {名前}です。{会社名}で働いています。
public class task3 {
  public static void main(String[] args) {
    Employee empA = new Employee("太郎", "山田", "アルソック");
    System.out.println(empA.introduceStatement());
    assert empA.introduceStatement().equals("私の名前は山田 太郎です。アルソックで働いています。") == true;
  }
}
