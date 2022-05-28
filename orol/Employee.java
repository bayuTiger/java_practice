package orol;

class Employee extends User {
  public final String companyName;

  public Employee(String firstName, String lastName, String companyName) {
    super(firstName, lastName);
    this.companyName = companyName;
  }

  @Override
  public String introduceStatement() {
    return "私の名前は" + this.lastName + " " + this.firstName + "です。" + companyName + "で働いています。";
  }
}
