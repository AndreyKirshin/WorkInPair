import java.util.HashMap;

public class MyHashMap<K, V> {
    public final static float LOAD_FACTOR = 0.75F;
    public final static int DEFOALT_CAPACITY = 16;
    int capacity;
    int length;

    Entry<K, V>[] table;

    public MyHashMap() {
        this.capacity = DEFOALT_CAPACITY;
        table = new Entry[DEFOALT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[this.capacity];
    }

    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }
        int hash = hash(key.hashCode());
        Entry<K, V> entry = new Entry<>(key, value, hash);
        float currentLoadFactor = length / capacity;
        if (currentLoadFactor > LOAD_FACTOR) {
            extendCapacity();
        }
        if (table[hash] == null) {
            table[hash] = entry;
        } else {
            if (key.equals(table[hash].getKey())) table[hash].setValue(value);
            else {
                Entry<K, V> nextOther = table[hash];
                while (nextOther.getNext() != null) {
                    nextOther = nextOther.getNext();
                }
                nextOther.setNext(entry);
            }
        }
        length++;
        return true;
    }

    public void extendCapacity() {
        Entry[] tempTable = new Entry[capacity];
        System.arraycopy(table, 0, tempTable, 0, capacity);
        capacity = capacity * 2;
        Entry[] newTable = new Entry[capacity];
        table = newTable;
        for (Entry e : tempTable) {
            if(e != null) {
                this.put((K) e.getKey(), (V) e.getValue());
            }
        }
    }

    public V get(K key) {
        if (length > 0)
            return table[hash(key.hashCode())].getValue();
        return null;
    }

    private int hash(int hashCode) {
        return hashCode % table.length;
    }

    private class Entry<K, V> {
        K key;
        V value;
        int hash;
        Entry<K, V> next;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", hash=" + hash +
                    ", next=" + next +
                    '}';
        }
    }
}
