package Implementation.Easy;

import java.util.*;

public class BraceBalance {
    public static void main(String[] args){
        String[] str = {"{}", "{}()[]", "[({})]","(","]","()[","]()","([{","(((","{(})","abc",""};
        isBalanced(str);
    }
    public static void isBalanced(String[] inputs){
        for(String input : inputs){
            System.out.println(isBalanced(input));
        }
    }
    public static String isBalanced(String input){
        Map<Character, Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for(Character ch : input.toCharArray()){
            if(ch == '[' || ch == '{' || ch == '(')
                stack.push(map.get(ch));
            if(ch == ']' || ch == '}' || ch == ')' )
                if(stack.isEmpty() || ch != stack.pop())
                    return "FALSE";
        }
        return stack.isEmpty() ? "TRUE" : "FALSE";
    }

}
