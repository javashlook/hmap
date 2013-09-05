package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * A typed hierarchical map with maximum of 4 key elements.
 * 
 */
public interface HMap4<K1, K2, K3, K4, V> extends HMap3<K1, K2, K3, K4> {

    public void put(K1 key1, K2 key2, K3 key3, K4 key4, V value);

    public List<V> getAll(K1 key1, K2 key2, K3 key3, K4 key4);

    public V get(K1 key1, K2 key2, K3 key3, K4 key4);

    public Set<V> values(K1 key1, K2 key2, K3 key3);

}