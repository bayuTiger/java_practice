package calc;

import java.util.*;

/**
 * アルゴリズム引用：http://www.gg.e-mansion.com/~kkatoh/program/novel2/novel208.html
 */
public class ConvertRpn {
    /**
     * 数式を逆ポーランド記法に変換.
     *
     * @param formula 逆ポーランド記法変換対象の数式
     * @return 逆ポーランド記法に変換した数式
     */
    public String getRpn(String formula) {
        char[] sequenceList = formula.toCharArray();
        // 戻り値を格納するStringBuilder
        StringBuilder resultBuilder = new StringBuilder(sequenceList.length);
        Deque<Character> stack = new ArrayDeque<>();

        // 数式をすべて逆ポーランド記法に変換するまでループを続ける
        for (char token : sequenceList) {
            switch (token) {
                case '+':
                case '-':
                    // スタックされた演算子の優先順位より低い場合は、スタックの演算子をバッファへ
                    while (!stack.isEmpty()) {
                        char c = stack.getFirst();
                        if (c == '*' || c == '/') {
                            resultBuilder.append(stack.removeFirst());
                        } else {
                            break;
                        }
                    }
                    stack.addFirst(token);
                    break;
                case '*':
                case '/':
                case '(':
                    stack.addFirst(token);
                    break;
                case ')':
                    // 「(」から「)」までの演算子をバッファへ
                    List<Object> list = Arrays.asList(stack.toArray());
                    int index = list.indexOf('(');

                    Deque<Character> workStack = new ArrayDeque<>();
                    for (int i = 0; i <= index; i++) {
                        char c = stack.removeFirst();
                        if (c != '(') {
                            workStack.addFirst(c);
                        }
                    }

                    while (!workStack.isEmpty()) {
                        resultBuilder.append(workStack.removeFirst());
                    }
                    break;
                default:
                    // 数値の場合
                    resultBuilder.append(token);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            resultBuilder.append(stack.removeFirst());
        }
        return resultBuilder.toString();
    }
}
