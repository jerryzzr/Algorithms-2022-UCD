public class Brute {
    /**
     * Brute force to search the pattern in a text
     * @param pattern
     * @param txt
     * @return
     * time complexity : O(Pattern * txt)
     * space complexity :O(n)
     */
    public static int search(String pattern,String txt) {
        final int n = txt.length();
        final int m = pattern.length();
        for (int i = 0; i<=n-m; i++) {
            int j;
            for(j=0;j<m;j++){
                if(txt.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if(j==m){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        long time =System.nanoTime();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        System.out.println(search(pat, txt));
        long nowtime = System.nanoTime()-time;
        System.out.println("Current time in nano: "+nowtime);
    }
}
/**
 * time complexity is O(m*n)
 */