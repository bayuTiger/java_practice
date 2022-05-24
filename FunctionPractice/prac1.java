package FunctionPractice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 仕様
		// - 関数名は all 
		// - 第一引数は List<String>
		// - 第二引数は String
		// - 第一引数のリストの中身がすべて第二引数で指定した値と一致していれば true, そうでなければ false を返す。

public class prac1 {
  public static void main(String[] args){
    List<String> aList = new ArrayList<>(Arrays.asList("a", "a", "a", "a", "a"));
		List<String> abList = new ArrayList<>(Arrays.asList("a", "b", "a"));

		assert all(aList, "a") == true;
		assert all(aList, "b") == false;
		assert all(abList, "a") == false;
		assert all(abList, "b") == false;
  }

  public static boolean all(List<String> list, String str){

    for(String s: list){
      if(!s.equals(str)){
        return false;
      }
    }
    return true;
  }
}




