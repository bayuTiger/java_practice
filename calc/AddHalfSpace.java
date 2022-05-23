package calc;

public class AddHalfSpace{
  public String addHalfSpace(String rpnFormula){
    if(rpnFormula.contains("+")){
      rpnFormula = rpnFormula.replace("+", " +");
      rpnFormula = rpnFormula.replace("-", " -");
      rpnFormula = rpnFormula.replace("*", " *");
      rpnFormula = rpnFormula.replace("/", " /");
    }else if(rpnFormula.contains("-")){
      rpnFormula = rpnFormula.replace("+", " +");
      rpnFormula = rpnFormula.replace("-", " -");
      rpnFormula = rpnFormula.replace("*", " *");
      rpnFormula = rpnFormula.replace("/", " /");
    }else if(rpnFormula.contains("*")){
      rpnFormula = rpnFormula.replace("+", " +");
      rpnFormula = rpnFormula.replace("-", " -");
      rpnFormula = rpnFormula.replace("*", " *");
      rpnFormula = rpnFormula.replace("/", " /");
    }else if(rpnFormula.contains("/")){
      rpnFormula = rpnFormula.replace("+", " +");
      rpnFormula = rpnFormula.replace("-", " -");
      rpnFormula = rpnFormula.replace("*", " *");
      rpnFormula = rpnFormula.replace("/", " /");
    }
    return rpnFormula;
  }
}
