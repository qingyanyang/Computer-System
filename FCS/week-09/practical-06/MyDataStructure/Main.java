class Main{
    //method to check if the string is even
    public static boolean bracketsMatching(String input){
        int i = 0;
        boolean noLose1 = false;
        boolean noLose2 = false;
        MyStack stack1 = new MyStack();
        MyStack stack2 = new MyStack();
        while(i < input.length()){
            if(String.valueOf(input.charAt(i)).matches("\\(")){
                Node node1 = new Node("(");
                stack1.push(node1);
                if(stack2.isEmpty())
                    noLose1 = true;
                else
                    noLose1 = false;
            }
            if(String.valueOf(input.charAt(i)).matches("\\{")){
                Node node2 = new Node("{");
                stack2.push(node2);
                if(stack1.isEmpty())
                    noLose2 = true;
                else
                    noLose2 = false;
            }
            if(String.valueOf(input.charAt(i)).matches("\\}")){
                if(stack2.isEmpty())
                    return false;
                else if(noLose2 && !stack1.isEmpty())
                    return false;
                else
                    stack2.pop();
            }
            if(String.valueOf(input.charAt(i)).matches("\\)")){
                if(stack1.isEmpty())
                    return false;
                else if(noLose1 && !stack2.isEmpty())
                    return false;
                else
                    stack1.pop();
            }
            i++;
        }
        if(!stack1.isEmpty())
            return false;
        if(!stack2.isEmpty())
            return false;
        return true;
    }
    //check if the string is an valid expression
    public static boolean equationMatching(String input){
        int index = 0;
        int i = 0;
        MyStack stack1 = new MyStack();
        if(!bracketsMatching(input)){
            System.out.println("brackets are not matching");
            return false;
        }else{
            System.out.println("brackets are matching");
            while(index < input.length()){
                String elemets = String.valueOf(input.charAt(index));
                if(elemets.matches("\\(")){
                    if(index > 0 && index < (input.length() - 1)){
                        String pre = String.valueOf(input.charAt(index - 1));
                        String bac = String.valueOf(input.charAt(index + 1));
                        if(bac.matches("\\*") || bac.matches("\\/") || bac.matches("\\+") || bac.matches("\\-") || pre.matches("^[0-9]+$")){
                            System.out.println("but it is not a valid expression");
                            return false;
                        }
                    }
                    if(stack1.isEmpty()){
                        i = index;
                    }
                    Node node1 = new Node("(");
                    stack1.push(node1);
                }else if(elemets.matches("\\)")){
                    if(index > 0 && index < (input.length() - 1)){
                        String pre = String.valueOf(input.charAt(index - 1));
                        String bac = String.valueOf(input.charAt(index + 1));
                        if(pre.matches("\\*") || pre.matches("\\/") || pre.matches("\\+") || pre.matches("\\-") || bac.matches("^[0-9]+$")){
                            System.out.println("but it is not a valid expression");
                            return false;
                        }
                    }
                    stack1.pop();
                    if(stack1.isEmpty()){
                        String s = input.substring(i, index + 1);
                        //System.out.println(s);
                        if(s.contains("{")){
                            System.out.println("but it is not a valid expression");
                            return false;
                        }
                    }
                }
                index++;
            }
            String inputNew = input.replace("{", "(");
            inputNew = inputNew.replace("}", ")");
            try{
                EvaluateString.evaluate(inputNew);
            }catch(Exception e){
                System.out.println("but it is not a valid expression");
                return false;
            }
        }
        return true;
    }
    //method to reverse queue
    public static MyQueue reverseQueue(MyQueue queue){
        MyQueue reverseQueue1 = new MyQueue();
        Node tmp1 = queue.getRear();

        while(tmp1 != null){
            String dataNew = tmp1.getData();
            Node nodeNew = new Node(dataNew);
            reverseQueue1.enqueue(nodeNew);
            tmp1 = tmp1.getNext();
        }
        return reverseQueue1;
    }
    //testing
    public static void main(String[] args){
        String a = "{()";
        String b = "{(})";
        String c = "({}){(())}";
        String d = "({1+2}*3)/2";
        String e = "(1+2) * {(2+3)*(3+4)}";
        String f = "(1+2){(2)*-7(4-)}";
        System.out.println(a);
        System.out.println(bracketsMatching(a));
        equationMatching(a);
        System.out.println("---------------------------------");
        System.out.println(b);
        System.out.println(bracketsMatching(b));
        equationMatching(b);
        System.out.println("---------------------------------");
        System.out.println(c);
        System.out.println(bracketsMatching(c));
        equationMatching(c);
        System.out.println("---------------------------------");
        System.out.println(d);
        System.out.println(bracketsMatching(d));
        equationMatching(d);
        System.out.println("---------------------------------");
        System.out.println(e);
        System.out.println(bracketsMatching(e));
        equationMatching(e);
        System.out.println("---------------------------------");
        System.out.println(f);
        System.out.println(bracketsMatching(f));
        equationMatching(f);
        System.out.println("---------------------------------");
        System.out.println("*********************************");
        MyQueue queue1 = new MyQueue();
        Node[] nodeArr = new Node[5];
        String h = "hello";
        int i = 0;
        for(i = 0; i < 5; i++){
            nodeArr[i] = new Node(String.valueOf(h.charAt(i)));
            queue1.enqueue(nodeArr[i]);
        }
        queue1.displayQueue();
        reverseQueue(queue1).displayQueue();
    }
}