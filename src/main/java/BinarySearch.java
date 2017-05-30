/**
 * Created by 1 on 30.05.2017.
 */
public class BinarySearch {


    public static int biSort(int element, int[] array) {
        int indexMiddle = (array.length - 1)/2;

        if(element == array[indexMiddle]) return indexMiddle;

        else if(element > array[indexMiddle]){
            int[] newArr = new int[indexMiddle];
            System.arraycopy(array, indexMiddle, newArr, 0, indexMiddle);
            if(element > newArr[newArr.length-1]) return -1;
            biSort(element, newArr);
        }
        else if(element < array[indexMiddle]) {
            int[] newArr = new int[indexMiddle];
            System.arraycopy(array, 0, newArr, 0, indexMiddle);
            if (element < newArr[0]) return -1;
            biSort(element, newArr);
        }
        return -1;
    }
}
