package inheritance;

// 以下で使われているCarクラス・PrintableIFインタフェースをそれぞれ作成せよ。
// Carクラスのprintlnの内部実装は任意のものでよい。

// class EnableInterfacePractice {
//   public static void main(String[] args) {
//     Car car = new Car("");
//     printlnObject(car);
//   }

//   private static void printlnObject(PrintableIF printableObject) {
//     printableObject.println();
//   }
// }

  class EnableInterfacePractice {
    public static void main(String[] args) {
      Car car = new Car("");
      printlnObject(car);
    }

    private static void printlnObject(PrintableIF printableObject) {
      printableObject.println();
    }
  }

