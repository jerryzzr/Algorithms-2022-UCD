public class Knapsack1 {
    /**
     * Brute-force
     * @param W
     * @param w
     * @param vals
     * @return
     * time complexity : O(2^n)
     * space complexity : O(1)
     */
    public static int knapsack(final int W, final int[] w, final int[] vals) {
        int maxV = 0;
        int n = w.length;
        int i,j;
        int r = (int) Math.pow(2,n);
        int[][] x=new int[r][n];
        for (i=0;i<r;i++){
            int k=i;
            for(j=0;j<n;j++){
                int v=k%2;
                x[i][j]=v;
                k=k/2;
            }
        }
        for ( i = 0; i < x.length; i++) {
            int currentV = 0;
            int currentW = 0;
            for ( j = 0; j < x[0].length; j++) {
                currentW += x[i][j]*w[j];
                currentV += x[i][j]*vals[j];
            }
            if (currentW <= W && currentV>maxV) {
                maxV = currentV;
            }
        }

        return maxV;
    }
        public static void main (String[]args){
            int[] w = {5, 3, 4, 2};
            int[] values = {60, 50, 70, 30};
            int W = 5;
            System.out.println(knapsack(W, w, values));
        }
    }
