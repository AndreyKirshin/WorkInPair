/**
 * Created by 1 on 13.06.2017.
 */
public class OurQuickSorting extends AbstractSortingAlgorithm {


    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        doSort(a, 0, a.length - 1);
    }

    public int[] sortIn(int[] a) {
        doSort(a, 0, a.length - 1);
        return a;
    }

    private void doSort(int[] a, int left, int right) {
        //if (left >= right) {
        //    return;
        //}

        int mddle = a[left + (right - left) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i] < mddle) i++;
            while (a[j] > mddle) j--;
            if (i <= j) {
                if (i < j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                i++;
                j--;
            }
        }
        if(i<right) doSort(a, i, right);
        if(left<j) doSort(a, left, j);

    }
}
