package inheritance;

public class Car implements PrintableIF {

  public Car(String string) {
  }

  @Override
  public void println() {
    System.out.println("optional");
  }
}
