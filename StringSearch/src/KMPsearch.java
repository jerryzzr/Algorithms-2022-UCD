public class KMPsearch {
    /**
     * KMP search for pattern from a text
     * @param pat
     * @param txt
     * time complexity : O(n)
     * space complexity :O(n)
     */
    void KMPSearch(final String pat, final String txt) {
        int M = pat.length();
        int N = txt.length();
// create lps[] that will hold the longest
// prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]
// Preprocess the pattern (calculate lps[]
// array)
        computeLPSArray(pat, M, lps);
        int i=0;
        while(i<N){
            if(pat.charAt(j)==txt.charAt(i)){
                ++i;
                ++j;
            }
            if(j==M){
                System.out.println("locate at "+(i-j));
                j=lps[j-1];
            }
            else if(pat.charAt(j)!=txt.charAt(i)){
                if(j==0){
                    i=i+1;
                }
                else{
                    j=lps[j-1];
                }
            }
        }


    }
    void computeLPSArray(final String pat, final int M, final int lps[]) {
// length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
// the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
// This is tricky. Consider the example.
// AAACAAAA and i = 7. The idea is similar
// to search step.
                if (len != 0) {
                    len = lps[len - 1];
// Also, note that we do not increment
// i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String args[]) {
        long time =System.nanoTime();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMPsearch().KMPSearch(pat, txt);
        long nowtime = System.nanoTime()-time;
        System.out.println("Current time in nano: "+nowtime);
    }
}
