public class week2 {
    /**
     *
     * @param x
     * @param y
     * @return
     * time complexity: O(logn)
     * space complexity: O(1)
     */
    public static int russianPeasantMult(final int x,final int y) {
        long time = System.nanoTime();
        int sum = 0;
        int a = x;
        int b = y;
        if(a>b) {
            while (b != 0) {
                if (b % 2 == 1) {
                    sum = sum + a;
                }
                a = a * 2;
                b = b / 2;
            }
        }else {
            while (a != 0) {
                if (a % 2 == 1) {
                    sum = b + sum;
                }
                a = a / 2;
                b = b * 2;
            }
        }
        long nowtime = System.nanoTime()-time;
        System.out.println("Current time in nano: "+nowtime);
        return sum;
    }

    /**
     *
     * @param A
     * @param N
     * @return
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public static int arraymax(int[] A,int N){
        long time = System.nanoTime();
        int currentMax = A[0];
        for(int i=0;i<N;i++){
            if(A[i]>currentMax){
                currentMax=A[i];
            }
        }
        long nowtime = System.nanoTime()-time;
        System.out.println("Current time in nano: "+nowtime);
        return currentMax;
    }
    public static void main(String[] args) {
        System.out.println(russianPeasantMult(13,238));
        System.out.println(russianPeasantMult(2,19));
        int[] A= {3, 4, 5, 6, 7};
        System.out.println(arraymax(A,5));
    }
}
