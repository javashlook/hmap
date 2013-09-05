package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * A typed hierarchical map with maximum of 2 key elements.
 * 
 */
public interface HMap2<K1, K2, V> {

    public Set<K1> keys();

    public Set<V> values();

    public Set<V> values(K1 key);

    public void put(K1 key, V value);

    public void put(K1 key1, K2 key2, V value);

    public void putByArray(Object[] keys, V value);

    public List<K2> getAll(K1 key);

    public List<V> getAll(K1 key1, K2 key2);

    public List<V> getAllByArray(Object[] keys);

    public K2 get(K1 key);

    public V get(K1 key1, K2 key2);

    public V getByArray(Object[] keys);

}