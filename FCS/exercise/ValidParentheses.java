import java.util.Stack;
public class ValidParentheses {
    public static boolean isValid(String s){
        int len = s.length();
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> stack3 = new Stack<String>();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                stack1.push("(");
            }else if(s.charAt(i) == ')'){
                if(stack1.empty()){
                    return false;
                }else{
                    stack1.pop();
                }
            }else if(s.charAt(i) == '['){
                stack2.push("[");
            }else if(s.charAt(i) == ']'){
                if(stack2.empty()){
                    return false;
                }else{
                    stack2.pop();
                }
            }else if(s.charAt(i) == '{'){
                stack3.push("{");
            }else if(s.charAt(i) == '}'){
                if(stack3.empty()){
                    return false;
                }else{
                    stack3.pop();
                }
            }
        }
        if(!stack1.isEmpty()){
            return false;
        }
        if(!stack2.isEmpty()){
            return false;
        }
        if(!stack3.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String test = "(]";
        System.out.println(isValid(test));
    }
}
