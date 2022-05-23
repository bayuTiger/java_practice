package exercise;

public class triangle4 {
  public static void main(String[] args){
    for (int i = 0; i < 6; i++) {
      for (int k = 0; k <= i; k++) {
        System.out.print(" ");
      }
      for (int j = 0; j < 6 - (i + 1); j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
}
