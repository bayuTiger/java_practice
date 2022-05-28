package orol;

public class User {
  public final String firstName;
  public final String lastName;

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String introduceStatement() {
    return "私の名前は" + this.lastName + " " + this.firstName + "です。";
  }

  @Override
  public String toString() {
    return "ユーザ(名字=" + lastName +
        ",名前=" + firstName + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof User)) {
      return false;
    }

    User other = (User) obj;

    if (firstName != other.firstName) {
      return false;
    }

    if (lastName != other.lastName) {
      return false;
    }

    return true;

  }
}
