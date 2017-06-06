/**
 * Created by 1 on 30.05.2017.
 */
public class BinarySearch {
    int element;
    int[] array;
    int left;
    int right;

    public BinarySearch(int element, int[] array) {
        this.element = element;
        this.array = array;
        left = 0;
        right = array.length - 1;
    }

    public int getResult(){
        return biSort(element, array, left, right);
    }

    public int biSort(int element, int[] array, int left, int right) {
        if(left > right) return -1;
        int indexMiddle = left + (right - left)/2;

        if(array[indexMiddle] == element) return indexMiddle;
        else if(element > array[indexMiddle]){
            return biSort(element, array, indexMiddle + 1, right);
        }
        else if(element < array[indexMiddle]){
            return biSort(element, array, left + 1, indexMiddle);
        }
        else return indexMiddle;
    }
}
