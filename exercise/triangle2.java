package exercise;

public class triangle2 {
  public static void main(String[] args){
    for (int i = 0; i < 5; i++) {
      for (int k = 0; k <= 5 - i; k++) {
        System.out.print(" ");
      }
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
}
