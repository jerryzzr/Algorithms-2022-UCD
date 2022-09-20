import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class binarySearch {
    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T elem, final Comparator<T> comparator){
        for(int i=0;i< array.length;i++){
            for(int j=0;j< array.length-1;j++){
                if(comparator.compare(array[j],array[j+1])==1){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
            }
        }
    }
       int mid=array.length/2;
        int x=array.length/2;
        while(x!=0){
            if(comparator.compare(array[mid],elem)==0){
                return mid;
            }
            if(comparator.compare(array[mid],elem)==1){
                mid=mid/2;
                x--;
            }
            else{
                mid=(mid+array.length-1)/2;
                x--;
            }
        }
        return -1;
    }
    public static <T extends Comparable<T>> int binarySearchRecursive(final T[]array, final T elem, final Comparator<T> comparator){
        for(int i=0;i< array.length;i++){
            for(int j=0;j< array.length-1;j++){
                if(comparator.compare(array[j],array[j+1])==1){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        int left=0;
        int right=array.length;
        int mid=(left+right)/2;
        if(left<=right){
            if(comparator.compare(array[mid],elem)==0){
                return mid;
            }
            if(comparator.compare(array[mid],elem)==1){
                right=mid-1;
                binarySearch(array,elem,comparator);
            }
            if(comparator.compare(array[mid],elem)==-1){
                left=mid+1;
                binarySearch(array,elem,comparator);
            }
            mid=(left+right)/2;
        }
        return mid;
    }
    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem, final Comparator<T> comparator){
        for(int i=0;i< list.size();i++){
            for(int j=0;j<list.size()-1;j++){
                if(comparator.compare(list.get(j+1),list.get(j))==-1){
                    T s=list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1,s);
                }
            }
        }
        int mid=list.size()/2;
        int x=list.size()/2;
        while(x!=0){
            if(comparator.compare(list.get(mid),elem)==0){
                return mid;
            }
            if(comparator.compare(list.get(mid),elem)==1){
                mid=mid/2;
                x--;
            }
            if(comparator.compare(list.get(mid),elem)==-1){
                mid=(mid+ list.size()-1)/2;
                x--;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Integer[] arr = {1,7,3,5,4,17,15,5};
        int elem=15;
        long timeA=System.nanoTime();
        int index=binarySearch(arr,elem,Integer::compareTo);
        long nowtime1 = System.nanoTime()-timeA;
        System.out.println("Current time(1) in nano: "+nowtime1);
        long timeB=System.nanoTime();
        int x=binarySearchRecursive(arr,elem,Integer::compareTo);
        long nowtime2 = System.nanoTime()-timeB;
        System.out.println("Current time(2) in nano: "+nowtime2);
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(17);
        list.add(15);
        list.add(5);
        long timeC=System.nanoTime();
        int y=binarySearch(list,elem,Integer::compareTo);
        long nowtime3 = System.nanoTime()-timeC;
        System.out.println("Current time(3) in nano: "+nowtime3);
        System.out.println(elem+" at the index: " +y);
        System.out.println(elem+" at the index: " +x);
        System.out.println(elem+" at the index: " +index);

    }
}