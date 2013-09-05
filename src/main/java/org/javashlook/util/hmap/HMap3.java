package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * A typed hierarchical map with maximum of 3 key elements.
 * 
 */
public interface HMap3<K1, K2, K3, V> extends HMap2<K1, K2, K3> {

    public void put(K1 key1, K2 key2, K3 key3, V value);

    public List<V> getAll(K1 key1, K2 key2, K3 key3);

    public V get(K1 key1, K2 key2, K3 key3);

    public Set<V> values(K1 key1, K2 key2);

}