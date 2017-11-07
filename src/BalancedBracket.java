import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char ch : expression.toCharArray()){
            if(ch == '{')
                stack.push('}');
            if(ch == '[')
                stack.push(']');
            if(ch == '(')
                stack.push(')');
            if(ch == '}' || ch == ']' || ch == ')'){
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(c != ch)
                    return false;
            }

        }
        if(!stack.isEmpty())
            return false;

        return true;
    }

    public static void main(String[] args) {
        //input
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/Anagram/test"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
