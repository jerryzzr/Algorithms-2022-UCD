public class Lcs1 {
    /**
     *
     * @param sOne
     * @param sTwo
     * @return length of lcs
     * time complexity : O(m*n)
     * space complexity : O(m*n)
     */
    public static int LCS(final String sOne, final String sTwo){
        int sOneLength=sOne.length();
        int sTwoLength=sTwo.length();
        int[][] x=new int[sOneLength+1][sTwoLength+1];
        for (int i=1;i< x.length;i++){
            for (int j=1;j<x[0].length;j++){
                if (sOne.charAt(i-1)==sTwo.charAt(j-1)){
                    x[i][j] = x[i-1][j-1]+1;
                }
                else {
                    x[i][j] = Math.max(x[i][j-1], x[i-1][j]);
                }
            }
        }
        return x[sOneLength][sTwoLength];
    }

    public static void main(String[] args) {
        String s1 = "ABABC";
        String s2 = "BABCA";
        System.out.println(LCS(s1,s2));
    }
}
