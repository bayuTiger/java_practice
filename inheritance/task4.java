package inheritance;

import java.util.Scanner;

// 以下の抽象クラスを実装したクラスを作成する。実装の詳細は任意に決める。

// abstract class IOHandlerBase {
//   abstract void printStartMessage();

//   abstract String input();

//   abstract void output(String message);

//   abstract void printEndMessage();

//   public void run() {
//     // 入力開始を示すメッセージを出力
//     printStartMessage();

//     // 入力待ち・入力結果の受け取り
//     String in = input();

//     // 入力値を任意に加工して出力
//     output(in);

//     // アプリケーション終了を示すメッセージを出力
//     printEndMessage();
//   }
// }

public class task4 {
  abstract class IOHandlerBase {
    abstract void printStartMessage();

    abstract String input();

    abstract void output(String message);

    abstract void printEndMessage();

    public void run() {
      // 入力開始を示すメッセージを出力
      printStartMessage();

      // 入力待ち・入力結果の受け取り
      String in = input();

      // 入力値を任意に加工して出力
      output(in);

      // アプリケーション終了を示すメッセージを出力
      printEndMessage();
    }
  }

  public class splittedMessage extends IOHandlerBase {
    String s;
    Scanner sc = new Scanner(System.in);
    String[] line;

    @Override
    void printStartMessage() {
      System.out.println("Starting");
    }

    @Override
    String input() {
      s = sc.nextLine();
      sc.close();
      return s;
    }

    @Override
    void output(String s) {
      line = s.split("");
      for (String e : line) {
        System.out.println(e);
      }
    }

    @Override
    void printEndMessage() {
      System.out.println("End");
    }

  }
}
