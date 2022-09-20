public class MinPriorityQueue<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;

    public MinPriorityQueue(int initCapacity) {
        this.pq = (Key[]) new Comparable[initCapacity + 1];
        this.N = 0;
    }
    public int size() {
        return this.N;
    }


    public void insert(Key x) {
        this.pq[this.N++] = x;
    }

    public Key delMin() {
        int min = 0;
        for (int i=1;i < N;i++) {
            if (pq[i].compareTo(pq[min]) < 0) min = i;
        }
        N--;
        //swap
        Key temp = pq[min];
        pq[min] = pq[N];
        pq[N] = temp;
        return temp;
    }
}
