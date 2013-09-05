package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * A typed hierarchical map with maximum of 5 key elements.
 * 
 */
public interface HMap5<K1, K2, K3, K4, K5, V> extends HMap4<K1, K2, K3, K4, K5> {

    public void put(K1 key1, K2 key2, K3 key3, K4 key4, K5 key5, V value);

    public List<V> getAll(K1 key1, K2 key2, K3 key3, K4 key4, K5 key5);

    public V get(K1 key1, K2 key2, K3 key3, K4 key4, K5 key5);

    public Set<V> values(K1 key1, K2 key2, K3 key3, K4 key4);

}