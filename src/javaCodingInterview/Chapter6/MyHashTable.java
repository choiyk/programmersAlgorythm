package javaCodingInterview.Chapter6;

public class MyHashTable<K,V> {

    private static final int SIZE = 11;
    private HashEntry<K,V>[] map;
    private int contentSize;

    public MyHashTable() {
        this.map = new HashEntry[SIZE];
    }

    public void put(K key, V value) {
        if(map[hash(key)] != null) {
            put(map[hash(key)], key, value);
        }
        else {
            map[hash(key)] = new HashEntry<>(key, value);
            contentSize++;
        }
    }

    public V get(K key) {
        if(map[hash(key)] != null) {
            return get(map[hash(key)], key);
        }
        else return null;
    }

    public int getSize() {
        return contentSize;
    }

    private void put(HashEntry<K,V> entry, K key, V value) {
        if(entry.key.equals(key)) {
            entry.value = value;
            return;
        }
        if(entry.next == null) {
            entry.next = new HashEntry<>(key, value);
            contentSize++;
            return;
        }
        put(entry.next, key, value);
    }

    private V get(HashEntry<K,V> entry, K key) {
        if(entry.key.equals(key))
            return entry.value;
        if(entry.next == null)
            return null;
        return get(entry.next, key);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    class HashEntry<K,V> {
        private K key;
        private V value;
        private HashEntry<K,V> next;

        public HashEntry(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
