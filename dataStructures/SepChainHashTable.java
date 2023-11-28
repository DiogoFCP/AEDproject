package dataStructures;  

/**
 * Separate Chaining Hash table implementation
 * @author AED  Team
 * @version 1.0
 * @param <K> Generic Key, must extend comparable
 * @param <V> Generic Value 
 */

public class SepChainHashTable<K extends Comparable<K>, V> 
    extends HashTable<K,V> 
{ 
	/**
	 * Serial Version UID of the Class.
	 */
    static final long serialVersionUID = 0L;

	/**
	 * The array of dictionaries.
	 */
    protected Dictionary<K,V>[] table;


    /**
     * Constructor of an empty separate chaining hash table,
     * with the specified initial capacity.
     * Each position of the array is initialized to a new ordered list
     * maxSize is initialized to the capacity.
     * @param capacity defines the table capacity.
     */
    @SuppressWarnings("unchecked")
    public SepChainHashTable( int capacity ) {
        int arraySize = HashTable.nextPrime((int) (1.1 * capacity));

        table = (Dictionary<K,V>[]) new Dictionary[arraySize];
        for ( int i = 0; i < arraySize; i++ )
            table[i] = new OrderedDoubleList<K,V>();
        maxSize = capacity;
        currentSize = 0;
    }                                      


    public SepChainHashTable( ) {
        this(DEFAULT_CAPACITY);
    }                                                                

    /**
     * Returns the hash value of the specified key.
     * @param key to be encoded
     * @return hash value of the specified key
     */
    protected int hash( K key )
    {
        return Math.abs( key.hashCode() ) % table.length;
    }

    @Override
    public V find( K key ) {
        return table[ this.hash(key) ].find(key);
    }

    @SuppressWarnings("unchecked")
    protected void rehash(){
        // TODO refazer com o construtor para otimizar/ criar nova sep hash table e buscar o .table e trocar neste
        // Creates new table
        Dictionary<K,V>[] oldTable = this.table;

        int newSize = HashTable.nextPrime((int) (1.1 * table.length));
        table = (Dictionary<K,V>[]) new Dictionary[newSize];
        for ( int i = 0; i < newSize; i++ )
            table[i] = new OrderedDoubleList<K,V>();
        maxSize = newSize;

        // Transfers all entry to new table
        for(int i=0; i< oldTable.length; i++){
            Iterator<Entry<K,V>> it = oldTable[i].iterator();
            while(it.hasNext()) {
                Entry<K,V> entry = it.next();
                table[this.hash(entry.getKey())].insert(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public V insert( K key, V value ) {
        if ( this.isFull() ) {
            this.rehash();
        }
        table[this.hash(key)].insert(key, value);
        currentSize++;
        return this.find(key);
    }

    @Override
    public V remove( K key ) {
        currentSize--;
        return table[this.hash(key)].remove(key);
    }

    @Override
    public Iterator<Entry<K,V>> iterator( )
    {
        List<Entry<K,V>> tmp = new DoubleList<>();
        for (int i = 0; i < this.table.length; i++) {
            Iterator<Entry<K,V>> it = table[i].iterator();
            while (it.hasNext())
                tmp.addLast(it.next());
        }
        return tmp.iterator();
    } 
}
