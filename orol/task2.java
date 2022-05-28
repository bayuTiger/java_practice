package orol;

// 同じクラスで同じ値をもつインスタンスに equals を使ったとき true が返却されるようにする
// 参考: https://www.bold.ne.jp/engineer-club/java-equals
public class task2 {
  public static void main(String[] args) {
    User userA = new User("太郎", "山田");
    User userB = new User("太郎", "山田");
    User userC = new User("次郎", "山田");
    User userD = userA;

    assert userA.equals(userB) == true;
    assert userA.equals(userC) == false;
    assert userB.equals(userC) == false;
    assert userA.equals(userD) == true;
  }

}
