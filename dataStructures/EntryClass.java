package dataStructures;

public class EntryClass<K, V> implements Entry<K, V>{

    private K key;

    private V value;

    public EntryClass(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
