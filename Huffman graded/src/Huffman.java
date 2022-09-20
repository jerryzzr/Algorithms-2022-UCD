public class Huffman {
    // alphabet size of extended ASCII
    private static final int R = 256;


    // Huffman trie node
    private record Node(char ch, int freq, Huffman.Node left, Huffman.Node right) implements Comparable<Node> {

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // throw input into char
        String string = BinaryStdIn.readString();
        char[] input = string.toCharArray();
        // count frequency of each char
        int[] frequency = new int[R];
        for (int i = 0; i < input.length; i++) {
            frequency[input[i]]++;
        }
        Node root = buildHuffmanTrie(frequency);//build trie
        String[] str = new String[R];
        buildHuffmanCode(str, root, "");
        writeTrie(root);
        BinaryStdOut.write(input.length);
        for (int i = 0; i < input.length; i++) {
            String c = str[input[i]];
            for (char a : c.toCharArray()) {
                if (a == '1') {
                    BinaryStdOut.write(true);
                } else if(a=='0'){
                    BinaryStdOut.write(false);
                }
                else
                {
                    throw new IllegalArgumentException("error");
                }

            }
        }
        BinaryStdOut.close();
    }

    private static Node buildHuffmanTrie(int[] freq) {
        // initialize PQ with singleton tries
        MinPriorityQueue pq = new MinPriorityQueue<Node>(R);
        for (char i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null));
            }
        }
        while (pq.size() > 1) {
            Node left = (Node) pq.delMin();
            Node right = (Node) pq.delMin();
            Node parent = new Node(' ',(left.freq + right.freq), left, right);
            pq.insert(parent);
        }
        return (Node) pq.delMin();
    }

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    private static void buildHuffmanCode(String[] str, Node x, String s) {
        if (!x.isLeaf()) {
            buildHuffmanCode(str, x.left, s + '0');
            buildHuffmanCode(str, x.right, s + '1');
        } else {
            str[x.ch] = s;
        }
    }

    public static void expand() {
        Node root = readTrie(); // encoding trie
        int N = BinaryStdIn.readInt(); // number of char
        //decode
        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                boolean bit = BinaryStdIn.readBoolean();
                if (bit) x = x.right;
                else x = x.left;
            }
            BinaryStdOut.write(x.ch, 8);
        }
        BinaryStdOut.close();
    }
    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(),-1, null, null);
        }
        else {
            return new Node('\0',-1, readTrie(), readTrie());
        }
    }
    public static void main(String[] args) {
        if (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}