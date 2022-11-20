public class StrImplement {
    public static int strStr(String needle, String haystack){
        int lenHay = haystack.length();
        int lenNee = needle.length();
        if(needle == null){
            return 0;
        }else{
            int j = 0;
            for(int i = 0; i < lenHay - lenNee; i++){
                while(j < lenNee && needle.charAt(j) == haystack.charAt(i)){
                    j++;
                    i++;
                }
                if(j == lenNee){
                    return i - lenNee;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String needle = "ll";
        String haystack = "hello";
        System.out.println(strStr(needle, haystack));
    }
}
