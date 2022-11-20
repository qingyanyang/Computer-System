public class LengthOfLastWord {
    public static int lengthOfLastWord(String s){
        String[] sArr = s.split(" ");
        int len = sArr.length;
        System.out.println("The last word is \"" + sArr[len - 1] + "\" with length " + sArr[len - 1].length() + ".");
        return sArr[len - 1].length();
    }

    public static void main(String[] args) {
        String s = "  fly me to  the  moon   ";
        lengthOfLastWord(s);
    }
}
