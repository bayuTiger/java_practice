public class pyramid1 {
  public static void main(String[] args){
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < (3 - i) * 2 - 1; k++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
}
