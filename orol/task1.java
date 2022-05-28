package orol;

// 		// --- Override --- //
// 		// User クラスを標準出力したときに ユーザ(名字=xxx,名前=yyy); のように出力されるようにする
// 		// 参考: https://www.delftstack.com/ja/howto/java/override-tostring-java/
// 		class User {
// 			public final String firstName;
// 			public final String lastName;
// 			public User(String firstName, String lastName) {
// 				this.firstName = firstName;
// 				this.lastName = lastName;
// 			}
// 			public String introduceStatement() {
// 				return "私の名前は" + this.lastName + " " + this.firstName + "です。";
// 			}
// 		}
// 		System.out.println(new User("太郎", "山田")); // -> ユーザ(名字=山田,名前=太郎) と出力されるようにする
// 		assert new User("太郎", "山田").toString().equals("ユーザ(名字=山田,名前=太郎)");

public class task1 {
    public static void main(String[] args) {

      System.out.println(new User("太郎", "山田")); // -> ユーザ(名字=山田,名前=太郎) と出力されるようにする
      assert new User("太郎", "山田").toString().equals("ユーザ(名字=山田,名前=太郎)");
    }


}
