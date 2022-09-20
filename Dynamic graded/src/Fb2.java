public class Fb2 {
    /**
     * Recursive
     * @param n
     * @return
     * time complexity : O(2^n)
     * space complexity : O(N)
     */
    public static int fib(final int n){
        if(n<=0){
            return 0;
        }
        else if(n==1){
            return 1;
        }else
            return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
