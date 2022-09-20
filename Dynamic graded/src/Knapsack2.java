
public class Knapsack2 {
    /**
     * dynamic programming
     * @param W
     * @param w
     * @param vals
     * @return
     * time complexity : O(N*W) //N is the number of goods
     * space complexity : O(1)
     */
    public static int knapsack(final int W, final int[] w, final int[] vals){
        int[][] x= new int[vals.length+1][W+1];
        int i;
        int j;
        for (i=1;i<x.length;i++){
            for (j=1;j<x[0].length;j++){
                if(w[i-1]>j){
                    x[i][j]=x[i-1][j];
                }
                else{
                    x[i][j]=Math.max(x[i-1][j],vals[i-1]+x[i-1][j-w[i-1]]);
                }
            }
        }
        return x[vals.length][W];
    }

    public static void main(String[] args) {
        int[] w={5,3,4,2};
        int[] values={60,50,70,30};
        int W=5;
        System.out.println(knapsack(W,w,values));
    }
}
