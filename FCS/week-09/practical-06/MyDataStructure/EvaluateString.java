import java.util.Stack;
public class EvaluateString{
    public static boolean evaluate(String expression){
        char[] tokens = expression.toCharArray();
         // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++){
            // Current token is a
            // whitespace, skip it
            if (tokens[i] == ' ')
                continue;
            // Current token is a number,
            // push it to stack for numbers
            if(tokens[i] >= '0' && tokens[i] <= '9'){
                StringBuffer sbuf = new StringBuffer();
                int j = i;
                while (j < tokens.length && tokens[j] >= '0' && tokens[j] <= '9'){
                    sbuf.append(tokens[j]);
                    j++;
                }
                values.push(Integer.parseInt(sbuf.toString()));
            }else if (tokens[i] == '('){
                ops.push(tokens[i]);
            // Closing brace encountered,
            // solve entire brace
            }else if (tokens[i] == ')'){
                while (ops.peek() != '('){
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' ||tokens[i] == '/'){
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())){
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }else{
                System.out.println("but it is not a valid equation");
                return false;
            }
        }
        while (!ops.empty()){
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        System.out.println("and it is also a valid expression, the value of it is: " + values.pop());
        return true;
    }

    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2){
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a){
        switch (op){
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException(
                      "Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

    // Driver method to test above methods
    public static void main(String[] args){
        EvaluateString.evaluate("(1+2)+((2)*(4))");
    }
}