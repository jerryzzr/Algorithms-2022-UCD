import java.util.*;

public class Sorting {
    /**
     * swap function when swap an array two adjacent elements
     * @param arr
     * @param i
     * @param j
     * @param <T>
     * T(n)=1+1+1+1=4
     */
    private static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i]; //1+1
        arr[i] = arr[j]; //1
        arr[j] = temp;   //1
    }

    /**
     * swaplist function when swap a list two adjacent elements
     * @param list
     * @param i
     * @param j
     * @param <T>
     *T(n)=1+1+1+1+1=5
     */

    private static <T> void swapList(List<T> list,int i,int j){
        T s=list.get(i); //1+1
        list.set(i, list.get(j));//1+1
        list.set(j,s);//1
    }
    /**
     *  for bogo sort, its a worst function
     *  just swap again and againn until its sorted
     * @param list
     * @param comparator
     * @param <T>
     * T(n)=3n-1
     * complexity: O(n)
     */
    public static <T extends Comparable<T>> void bogoSort(final List<T> list, final Comparator<T> comparator) {
        while(!bogoSorted(list,comparator)) { // 1+3n-1
            Collections.shuffle(list); // 1
        }
//        System.out.println(list);
    }

    /**
     * a sorted function to check its sorted or not
     * @param list
     * @param comparator
     * @param <T>
     * @return
     * T(n)=(n+n)+(n-1)=3n-1
     */
    public static <T extends Comparable<T>> boolean bogoSorted(final List<T> list, final Comparator<T> comparator) {
        for(int i =0;i< list.size()-1;i++){ //2n
            if(comparator.compare(list.get(i),list.get(i+1))==1){ //n-1
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * T(n)=3n+1+1+5=3n+7
     * complexity=O(n)
     **/
    public static <T extends Comparable<T>> void bogoSort(final T[] array, final Comparator<T> comparator) {
        while(!bogoSorted(array,comparator)){//1+3n-1
            int i=array.length-1; //1
            while(i>0){ //1
                swap(array,i--,(int)(Math.random()*i));//1+4
                //swap randomly until its sorted
            }
        }
//        System.out.println(Arrays.stream(array).toList());
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * T(n)=2n+n-1=3n-1
     * @return
     */
    public static <T extends Comparable<T>> boolean bogoSorted(final T[] array, final Comparator<T> comparator) {
        // a sorted function to check its sorted or not
        for(int i =0;i< array.length-1;i++){ //2n
            if(comparator.compare(array[i], array[i+1])==1){//n-1
                return false;
            }
        }
        return true;
    }

    /**
     * bubble sort is compare adjacent elements
     * if first one bigger than second one then move the first number to next then compare the second(origin first num)with next again and again
     * so first loop we can compare n numbers with n-1 times, the second loop will do n-1 numbers, with n-2 times ........until its sorted
     * @param list
     * @param comparator
     * @param <T>
     * T(n)=(2n+1)(2n)+n-1+5=4n^2+3n+4
     * complexity=O(n^2)
     */
    public static <T extends Comparable<T>> void bubbleSort(final List<T> list, final Comparator<T> comparator) {
        for(int i=0;i< list.size();i++){// 2n+1
            for(int j=0;j<list.size()-1;j++){ //2n
                if(comparator.compare(list.get(j+1),list.get(j))==-1){ //n-1
                    swapList(list,j,j+1);// 5
                }
            }
        }
//        System.out.println(list);
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * T(n)=(2n+1)*2n+n-1+4=4n^2+3n+3
     * complexity=O(n^2)
     */
    public static <T extends Comparable<T>> void bubbleSort(final T[] array, final Comparator<T> comparator) {
        for(int i=0;i< array.length;i++){//2n+1
            for(int j=0;j< array.length-1;j++){//2n
                if(comparator.compare(array[j],array[j+1])==1){//n-1
                    swap(array,j,j+1);//4
                }
            }
        }
//        System.out.println(Arrays.stream(array).toList());
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     * T(n)= (2n*(2n+1))+n-1+n-1+n-1+5=4n^2+5n+2
     * complexity:O(n^2)
     */
    public static <T extends Comparable<T>> void selectionSort(final List<T> list, final Comparator<T> comparator) {
        for(int i=0;i< list.size()-1;i++){//2n
            int min=i;//n-1
            for(int j=i+1;j<list.size();j++){//2n+1
                if(comparator.compare(list.get(min),list.get(j))==1){//n-1
                    min=j;//n-1
                }
            }
            swapList(list,i,min);//5
        }
//        System.out.println(list);
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     *  T(n)= (2n*(2n+1))+n-1+n-1+n-1+4=4n^2+5n+1
     *  complexity:O(n^2)
     */
    public static <T extends Comparable<T>> void selectionSort(final T[] array, final Comparator<T> comparator) {
        for(int i=0;i< array.length-1;i++){ // 2n
            int min=i; // n-1
            for(int j=i+1;j< array.length;j++){ // 2n+1
                if(comparator.compare(array[min],array[j])==1){ // n-1
                    min=j; // n-1
                }
            }
            swap(array,i,min);//4
        }
//        System.out.println(Arrays.stream(array).toList());
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *  T(n)=1+2+2+3+2n+1+2n+1+2n+1+2n+1+1+1+5n+10=13n+24
     *  complexity:O(nLogn)
     */
    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        if(list.isEmpty() || list.size()<2) {
            return;
        } // 1
        int size= list.size()/2; //1+1
        List<T> left=list.subList(0,size); //1+1
        List<T> right=list.subList(size, list.size()); // 1+1+1
        for(int i=0;i<size;i++){ // 2n+1
            left.set(i, list.get(i)); //2n+1
        }
        for(int i=size;i< list.size();i++){ //2n+1
            right.set(i-size, list.get(i)); //2n+1
        }
        mergeSort(left,comparator); // 1
        mergeSort(right,comparator); // 1
        merge(list,left,right,size, list.size()-size,comparator);//5n+10
    }

    /**
     *
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     * @param comparator
     * @param <T>
     * T(n)=3+2+n-1+n+1+n+1+1+n+1+1+n+1=5n+10
     */
    public static <T extends Comparable<T>> void merge(List<T> a, List<T> l, List<T> r, int left, int right,final Comparator<T> comparator) {
        int i = 0, j = 0, k = 0; // 3
        while (i < left && j < right) { // 1+1
            if (comparator.compare(l.get(i),r.get(j)) != 1) {// n-1
                a.set(k++,l.get(i++)); //n+1
            } else {
                a.set(k++,r.get(j++));//n+1
            }
        }
        while (i < left) {//1
            a.set(k++,l.get(i++));//n+1
        }
        while (j < right) {//1
            a.set(k++,r.get(j++));//n+1
        }

    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * T(n)=1+2+2+3+2n+1+2n+2n+1+2n+1+1+5n+6=13n+20
     * complexity=O(nLogn)
     */
    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {
        if(array.length<2){
            return;
        }//1
        int size= array.length/2;//1+1
        T[] left= Arrays.copyOfRange(array,0,size);//1+1
        T[] right=Arrays.copyOfRange(array,size,array.length);//1+1+1
        for(int i=0;i<size;i++){//2n+1
            left[i]=array[i];//2n
        }
        for(int i=size;i<array.length;i++){//2n+1
            right[i-size]=array[i];//2n
        }
        mergeSort(left,comparator);//1
        mergeSort(right,comparator);//1
        merge(array,left,right,size,array.length-size,comparator);//5n+6
    }

    /**
     *
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     * @param comparator
     * @param <T>
     * T(n)=3+2+n-1+n+n+1+n+1+n=5n+6
     */
    public static <T extends Comparable<T>> void merge(T[] a, T[] l, T[] r, int left, int right,final Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;//3
        while (i < left && j < right) {//1+1
            if (comparator.compare(l[i], r[j]) != 1) {//n-1
                a[k++] = l[i++];//n
            } else {
                a[k++] = r[j++];//n
            }
        }
            while (i < left) {//1
                a[k++] = l[i++];//n
            }
            while (j < right) {//1
                a[k++] = r[j++];//n
            }
        }

    /**
     * for the pivot,we always choose the first one of list. and we can also select it randomly.
     * former one not very stable, and randomly need more time. So they are two different way but both have advantage and shortage.
     * if the list is from large to small, it will waste a lot of times.
     * if the list size is small, quick sort is not good as the selection sort.
     * @param list
     * @param comparator
     * @param <T>
     * complexity=O(nlogN)
     */
    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {
        sort(list,0, list.size()-1, comparator);
//        System.out.println(list);

    }

    /**
     *
     * @param a
     * @param lo
     * @param hi
     * @param comparator
     * @param <T>
     * T(n)=2n+23
     */
    private static <T extends Comparable<T>> void sort(List<T> a, int lo, int hi,Comparator comparator)
    {
        if (hi <= lo) return;//1
        int j = partition(a, lo, hi,comparator);//1+2n+19
        sort(a, lo, j-1,comparator);//1
        sort(a, j+1, hi,comparator);//1
    }

    /**
     *
     * @param list
     * @param low
     * @param high
     * @param comparator
     * @param <T>
     * @return
     * T(n)=2+2+1+n-1+1+n-1+1+1+5+5+1=2n+19
     */
    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high,Comparator<T> comparator){
        int i = low; //2
        int j = high+1; //2
        while(true){//1
            while(comparator.compare(list.get(++i), list.get(low))==-1){//n-1
                if(i==high){//1
                    break;
                }
            }
            while(comparator.compare(list.get(low),list.get(--j))==-1){//n-1
                if(j==low){//1
                    break;
                }
            }
            if(i>=j){//1
                break;
            }
            swapList(list,i,j);//5
        }
        swapList(list,low,j);//5
        return j;//1
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * complexitu=O(nLogn)
     */
    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {
        sort(array,0,array.length-1,comparator);
//        System.out.println(Arrays.stream(array).toList());
    }
    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi,Comparator comparator)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi,comparator);
        sort(a, lo, j-1,comparator);
        sort(a, j+1, hi,comparator);
    }
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high,Comparator<T> comparator){
        int i = low;
        int j = high+1;
        while(true){
            while(comparator.compare(array[++i],array[low])==-1){
                if(i==high){
                    break;
                }
            }
            while(comparator.compare(array[low],array[--j])==-1){
                if(j==low){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(array,i,j);
        }
        swap(array,low,j);
        return j;
    }
//    public static void main(String[] args) {
//        int i=0;
//        List<Integer> list= new ArrayList<>(4);
//        list.add(1);
//        list.add(7);
//        list.add(3);
//        list.add(5);
//        list.add(4);
//        list.add(17);
//        list.add(15);
//        list.add(5);
//        long startTime1=System.nanoTime();
//        bogoSort(list,Integer::compareTo);
//        long a=System.nanoTime()-startTime1;
//        System.out.println(a);
//        bubbleSort(list,Integer::compareTo);
//        selectionSort(list,Integer::compareTo);
//        mergeSort(list,Integer::compareTo);
//        System.out.println(list);
//        quickSort(list,Integer::compareTo);
//        Integer[] arr = new Integer[9];
//        arr[0]=1;
//        arr[1]=7;
//        arr[2]=3;
//        arr[3]=9;
//        arr[4]=14;
//        arr[5]=11;
//        arr[6]=19;
//        arr[7]=22;
//        arr[8]=7;
//        bogoSort(arr,Integer::compareTo);
//        bubbleSort(arr,Integer::compareTo);
//        selectionSort(arr,Integer::compareTo);
//        mergeSort(arr,Integer::compareTo);
//        System.out.println(Arrays.stream(arr).toList());
//        quickSort(arr,Integer::compareTo);
//    }
}
