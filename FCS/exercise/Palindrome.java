public class Palindrome {
    public static boolean isPalindrome(int x){
        String convertToS = "" + x;
        int len = convertToS.length();
        for(int i = 0, j = len - 1; i < len / 2; i++, j--){
            if(convertToS.charAt(i) != convertToS.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] test = {121, -121, 10, 2332};
        for(int i : test){
            System.out.println(isPalindrome(i));
        }
    }
}
