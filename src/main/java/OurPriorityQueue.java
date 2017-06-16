/**
 * Created by 1 on 15.06.2017.
 */
public class OurPriorityQueue {
    int[] massive;
    int capacity = 16;
    int size;

    public OurPriorityQueue() {
        this.massive = new int[capacity];
    }

    void insert(int value) {
        if (isEmpty()) massive[1] = value;
        else if (size < capacity) {
            massive[size + 1] = value;
            swimUp(size + 1);
        } else {
            grow();
        }
        size++;
    }

    private void grow() {
    }

    int delMax() {
        int max = massive[1];
        massive[1] = massive[size];
        massive[size] = 0;
        size--;
        sink(1);
        return max;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void swimUp(int index) {
        while ((index > 1) && massive[index] > massive[index / 2]) {
            int temp = massive[index / 2];
            massive[index / 2] = massive[index];
            massive[index] = temp;
            index = index / 2;
        }
    }

    void sink(int index) {
        while (2 * index <= size) {
            int j = 2 * index;
            if ((j < size) && (massive[j] < massive[j + 1])) {
                j++;
            }
            if (massive[j] < massive[index]) {
                break;
            }
            int tmp = massive[index];
            massive[index] = massive[j];
            massive[j] = tmp;
            index = j;
        }

    }

    void swipDownOld(int index) {
        int maxChildIndex;
        while (index < size &&
                massive[(maxChildIndex = massive[index * 2] > massive[index * 2 + 1] ? index * 2 : index * 2 + 1)] > massive[index]) {
            int temp = massive[maxChildIndex];
            massive[maxChildIndex] = massive[index];
            massive[index] = temp;

            index = maxChildIndex;
        }
    }
}
