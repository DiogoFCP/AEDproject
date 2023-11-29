package dataStructures;

/**
 * Entry class implementation that holds K key and V value
 * @param <K,V> Generics
 * @author DIOGOPINHEIRO (65122) df.pinheiro@campus.fct.unl.pt
 * @author TIAGOCOSTA (64398) tr.costa@campus.fct.unl.pt
 */
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

    public void setKey(K newKey) {
        this.key = newKey;
    }

    public void setValue(V newValue) {
        this.value = newValue;
    }
}
