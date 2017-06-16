public class OurShellSorting extends AbstractSortingAlgorithm {

    @Override
    public void sort(Comparable[] a) {

    }

    public void sort(int[] array) {
        int indMiddle = 1;
        while(indMiddle <array.length/3) indMiddle = 3*indMiddle+1;

        while (indMiddle >= 1) {
            for (int i = 0; i < array.length - indMiddle; i++) {
                int j = i;
                while (j >= 0 && array[j] > array[j + indMiddle]) {
                    int tmp = array[j];
                    array[j] = array[j + indMiddle];
                    array[j + indMiddle] = tmp;
                    j--;
                }
            }
            indMiddle = indMiddle / 3;
        }
    }
}
