import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 1 on 13.06.2017.
 */
public class OurMergeSorting extends AbstractSortingAlgorithm {
    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        doSort(a, 0, a.length - 1);
    }

    public void doSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int midle = lo + (hi - lo) / 2;
        int tmp[] = new int[a.length];
        doSort(a, lo, midle);
        doSort(a, midle + 1, hi);
        merge(a, tmp, lo, midle, hi);
    }

    public static void merge(int[] a, int[] temp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = temp[j++];
            else if (j > hi) a[k] = temp[i++];
            else if (less(temp[j], temp[i])) a[k] = temp[j++];
            else a[k] = temp[i++];
        }
    }
}
