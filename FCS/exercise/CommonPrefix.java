public class CommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        int len = strs.length;
        String tmp = "";
        String commonPrefix = "";
        int count = 0;
        int j = 0;
        while(true) {
            for (int i = 0; i < len - 1; i++) {
                if (strs[i].charAt(j) != strs[i + 1].charAt(j)) {
                    return commonPrefix;
                } else {
                    count++;
                }
                if (count == len - 1) {
                    tmp = "" + strs[i].charAt(j);
                }
            }
            count = 0;
            j++;
            commonPrefix += tmp;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"fly", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
