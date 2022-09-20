import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SortingTest {
    private static final Set<String> validMethods = new HashSet<>();
    private static final int SIZE = 10000;

    static {
        validMethods.add("bubbleSort");
        validMethods.add("selectionSort");
        validMethods.add("quickSort");
        validMethods.add("mergeSort");
    }

    public static final List<Method> listSortingMethods = Arrays.stream(Sorting.class.getMethods())
            .filter(method -> Arrays.stream(method.getParameterTypes()).anyMatch(clazz -> clazz == List.class))
            .filter(method -> validMethods.contains(method.getName())).toList();

    public static final List<Method> arraySortingMethods = Arrays.stream(Sorting.class.getMethods())
            .filter(method -> Arrays.stream(method.getParameterTypes()).noneMatch(clazz -> clazz == List.class))
            .filter(method -> validMethods.contains(method.getName())).toList();

    private final Random random = new Random(Instant.now().toEpochMilli());

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < arraySortingMethods.size(); i++) {
            data.add(new Object[]{listSortingMethods.get(i), arraySortingMethods.get(i)});
        }
        return data;
    }

    @Parameterized.Parameter(0)
    public Method listSortingMethod;

    @Parameterized.Parameter(1)
    public Method arraySortingMethod;

    @Test
    public void correctNumberOfMethods() {
        for(Method a : listSortingMethods){
            System.out.println(a);
        }
        assertEquals(listSortingMethods.size(), validMethods.size());
        assertEquals(arraySortingMethods.size(), validMethods.size());
    }

    @Test
    public void canSort() throws InvocationTargetException, IllegalAccessException {
        final List<Integer> integers = new ArrayList<>();
        random.ints(SIZE, 0, 100).boxed().forEach(integers::add);
        assertFalse(isSorted(integers, Comparator.comparing(Integer::intValue)));
        listSortingMethod.invoke(null, integers, Comparator.comparing(Integer::intValue));
        assertTrue(isSorted(integers, Comparator.comparing(Integer::intValue)));

        final Integer[] integerArray = random.ints(SIZE, 0, 100).boxed().toList().toArray(new Integer[SIZE]);
        assertFalse(isSorted(integerArray, Comparator.comparing(Integer::intValue)));
        arraySortingMethod.invoke(null, integerArray, Comparator.comparing(Integer::intValue));
        assertTrue(isSorted(integerArray, Comparator.comparing(Integer::intValue)));

        final List<Double> doubles = new ArrayList<>();
        random.doubles(SIZE, 0, 100).boxed().forEach(doubles::add);
        assertFalse(isSorted(doubles, Comparator.comparing(Double::doubleValue)));
        listSortingMethod.invoke(null, doubles, Comparator.comparing(Double::doubleValue));
        assertTrue(isSorted(doubles, Comparator.comparing(Double::doubleValue)));

        final Double[] doubleArray = random.doubles(SIZE, 0, 100).boxed().toList().toArray(new Double[SIZE]);
        assertFalse(isSorted(doubleArray, Comparator.comparing(Double::doubleValue)));
        arraySortingMethod.invoke(null, doubleArray, Comparator.comparing(Double::doubleValue));
        assertTrue(isSorted(doubleArray, Comparator.comparing(Double::doubleValue)));

        final List<TestClass> testClasses = generateRandomTestClasses();
        assertFalse(isSorted(testClasses, Comparator.comparing(TestClass::getComparisonValue)));
        listSortingMethod.invoke(null, testClasses, Comparator.comparing(TestClass::getComparisonValue));
        assertTrue(isSorted(testClasses, Comparator.comparing(TestClass::getComparisonValue)));

        final TestClass[] testClassArray = generateRandomTestClasses().toArray(new TestClass[SIZE]);
        assertFalse(isSorted(testClassArray, Comparator.comparing(TestClass::getComparisonValue)));
        arraySortingMethod.invoke(null, testClassArray, Comparator.comparing(TestClass::getComparisonValue));
        assertTrue(isSorted(testClassArray, Comparator.comparing(TestClass::getComparisonValue)));
    }

    static <T extends Comparable<T>> boolean isSorted(final List<T> list, final Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            final T current = list.get(i);
            final T next = list.get(i + 1);
            if (comparator.compare(current, next) > 0) {
                return false;
            }
        }
        return true;
    }

    static <T extends Comparable<T>> boolean isSorted(final T[] array, final Comparator<T> comparator) {
        return isSorted(Arrays.asList(array), comparator);
    }

    private List<TestClass> generateRandomTestClasses() {
        final List<TestClass> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            final long randomLong = random.nextLong();
            final float randomFloat = random.nextFloat();
            list.add(new TestClass(randomLong, randomFloat));
        }
        return list;
    }

    private record TestClass(long valueOne, float valueTwo) implements Comparable<TestClass> {

        private Float getComparisonValue() {
            return valueOne * valueTwo;
        }

        @Override
        public int compareTo(final TestClass other) {
            return this.getComparisonValue().compareTo(other.getComparisonValue());
        }
    }
}
