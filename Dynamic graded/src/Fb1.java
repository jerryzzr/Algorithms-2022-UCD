public class Fb1 {
    /**
     *  Dynamic Programming
     * @param n
     * @return
     * time complexity : O(N)
     * space complexity : O(1)
     */
    public static int fib(final int n){
        int[] a =new int[n+1];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<=a.length-1;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
