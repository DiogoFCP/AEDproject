package dataStructures;

import java.io.Serializable;

/**
 * Entry Abstract Data Type
 * Includes description of general methods to be implemented by an entry.
 *
 * @param <K> Generic Key
 * @param <V> Generic Value
 * @author AED  Team
 * @version 1.0
 */

public interface Entry<K, V> extends Serializable {
    /**
     * Returns the key in the entry.
     *
     * @return key in the entry
     */
    K getKey();

    /**
     * Returns the value in the entry.
     *
     * @return value in the entry
     */
    V getValue();

    /**
     * Sets the key to the given key.
     *
     * @param newKey the key being changed.
     */
    void setKey(K newKey);

    /**
     * Sets the value to the given value.
     *
     * @param newValue the value being changed.
     */
    void setValue(V newValue);

}
