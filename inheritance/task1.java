package inheritance;

import java.util.Date;
import java.io.Serializable;

// 以下のクラスを、JavaBeansの要件を満たすかたちへと修正
// JavaBeansの仕様
// クラスをpublicで指定する
// プロパティ(クラスのメンバ変数)はprivateで指定する
// public指定で引数なしのコンストラクタを定義する
// プロパティにアクセスするためのgetter、setterメソッドを用意する
// java.io.Serializableインタフェースを実装する(必須ではない)
// パッケージ化する
// クラス名の最後は慣例的にBeanにする

// class Person {
//   private String name;
//   private int age;
//   private Date birthDate;

//   public Person(String name, int age, Date birthDate) {
//     this.name = name;
//     this.age = age;
//     this.birthDate = birthDate;
//   }
// }


public class task1 {
  public class PersonBean implements Serializable {
    private String name;
    private int age;
    private Date birthDate;

    public PersonBean() {
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public void setDate(Date birthDate) {
      this.birthDate = birthDate;
    }

    public String getName() {
      return this.name;
    }

    public int getAge() {
      return this.age;
    }

    public Date getDate() {
      return this.birthDate;
    }
  }

}
