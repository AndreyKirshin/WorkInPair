public class OurInsertionSorting extends AbstractSortingAlgorithm {


    @Override
    public void sort(Comparable[] a) {

    }

    public void sort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j;
            for (j = i - 1; (j >= 0) && (array[j] > value); j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = value;
        }
    }
}
