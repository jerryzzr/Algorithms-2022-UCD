import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    private static final List<String> filePaths = new ArrayList<>();

    static {
        filePaths.add("week4/resources/1Kints.txt");
        filePaths.add("week4/resources/2Kints.txt");
        filePaths.add("week4/resources/4Kints.txt");
        filePaths.add("week4/resources/8Kints.txt");
        filePaths.add("week4/resources/16Kints.txt");
    }

    public static void main(final String[] args) throws IOException {
        int i = 0;
        long[] a=new long[5];
        long[] b=new long[5];
        for (final String path : filePaths) {
            // do something
            long startTimeA=System.nanoTime();
            threeSumA(loadFileAsIntArray(path));
            a[i]=System.nanoTime()-startTimeA;
            long startTimeB=System.nanoTime();
            threeSumB(loadFileAsIntArray(path));
            b[i]=System.nanoTime()-startTimeB;
            i++;
            System.out.println(i);
        }
        for(int j=0;j<5;j++) {
            System.out.println("Three sum A:"+a[j]);
            System.out.println("Three sum B:"+b[j]);
        }
    }

    /**
     * ThreeSum A use brute force algorithm
     * @param array
     * @return
     * time complexity:O(n^3)
     */
    public static int threeSumA(final int[] array) {
        final int length = array.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int threeSumB(final int[] array) {
        final int length = array.length;
        Arrays.sort(array);
        if (Arrays.stream(array).distinct().toArray().length != length) {
            throw new IllegalArgumentException("Input array contains duplicates");
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] loadFileAsIntArray(final String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).stream().mapToInt(Integer::parseInt).toArray();
    }
}
