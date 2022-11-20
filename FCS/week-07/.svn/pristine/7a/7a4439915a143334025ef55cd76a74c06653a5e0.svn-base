import java.util.*;//stack
import java.util.Arrays;
class Formatting{
    //method to enable element from the same class to have format like : 123@[abc]
    public ArrayList<String> format(String s){
        int n = s.length();
        ArrayList<String> listString = new ArrayList<String>();
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        //get [abc][][]... arraylist
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i)=='['){
                stack.push(i);
            }else if(s.charAt(i)==']'){
                start = (Integer)stack.pop();
                if(stack.isEmpty())
                    listString.add(s.substring(start, i + 1));
            }
        }
        //find loose letters to make it like 1@[a] and insert to new arralist
        int j = 0, l = 0;
        ArrayList<String> listString2 = new ArrayList<String>();
        while(j < listString.size()){
            String ss = s.substring(0, s.indexOf(listString.get(j)));
            String constant = "";
            String letterString = "";
            //get constant number
            for(int k = 0; k < ss.length(); k++){
                if(String.valueOf(ss.charAt(k)).matches("^[0-9]+$"))
                    constant += ss.charAt(k);
            }
            listString2.add(constant + "@" + listString.get(j));
            //find loose letters
            if(constant.length() != ss.length()){
                letterString = ss.substring(0, ss.length() - constant.length());
                listString2.add(j + l, ("1@[" + letterString + "]"));
                l++;
            }
            s = s.substring(s.indexOf(listString.get(j)) + listString.get(j).length(), s.length());
            j++;
        }
        //find loose letter behind []
        if(s != null)
            listString2.add(("1@[" + s + "]"));
        return listString2;
    }
}