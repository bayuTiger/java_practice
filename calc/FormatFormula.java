package calc;

public class FormatFormula {
  public String[] format(String rpnFormula){

    // 算術演算子の前に半角スペースを入れる
    AddHalfSpace addHalfSpace = new AddHalfSpace();
    rpnFormula = addHalfSpace.addHalfSpace(rpnFormula);
    System.out.println("オペランドを変換したrpn式：" + rpnFormula);

    //全角スペースを半角スペースに置換
    rpnFormula = rpnFormula.replaceAll("  ", " ");
    System.out.println("全角スペースを半角スペースに置換：" + rpnFormula);

    // 文頭文末の空白を削除
    rpnFormula = rpnFormula.trim();

    // Rpn式を配列に変換
    String[] operand = rpnFormula.split(" ");

    return operand;
  }
}
