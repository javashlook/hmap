package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * An untyped hierarchical map.
 * <p>
 * Allows something like:
 * 
 * <pre>
 *      HMap hmap = ...;
 *      hmap.put(1, "A", "X", 10);
 *      hmap.put(1, "B", "X", 15);
 *      hmap.put(2, "C", "X", 20);
 * 
 *      hmap.getAll(null);              // A, B, C
 *      
 *      hmap.getAll(1);                 // A, B
 *      hmap.getAll(1, null, "X");      // 10, 15
 *      hmap.get(2, "C", "X");          // 20
 *      hmap.getAll(null, null, "X");   // 10, 15, 20
 * 
 *      hmap.getAll(3);                 // empty
 *      hmap.get(3);                    // null
 *      hmap.get(3, "D", "Y");          // null
 * 
 *      hmap.values();                  // 10, 15, 20
 *      hmap.values(1);                 // 10, 14
 *      hmap.values(2);                 // 20
 *      hmap.values(1, "A");            // 10
 * </pre>
 */
public interface HMap {

    public Set<?> keys();

    public Set<?> values();

    public void put(Object key, Object value);

    public void put(Object key1, Object key2, Object value);

    public void put(Object key1, Object key2, Object key3, Object value);

    public void put(Object key1, Object key2, Object key3, Object key4, Object value);

    public void put(Object key1, Object key2, Object key3, Object key4, Object key5, Object value);

    public void putByArray(Object[] keys, Object value);

    public List<?> getAll(Object key);

    public List<?> getAll(Object key1, Object key2);

    public List<?> getAll(Object key1, Object key2, Object key3);

    public List<?> getAll(Object key1, Object key2, Object key3, Object key4);

    public List<?> getAll(Object key1, Object key2, Object key3, Object key4, Object key5);

    public List<?> getAllByArray(Object[] keys);

    public Object get(Object key);

    public Object get(Object key1, Object key2);

    public Object get(Object key1, Object key2, Object key3);

    public Object get(Object key1, Object key2, Object key3, Object key4);

    public Object get(Object key1, Object key2, Object key3, Object key4, Object key5);

    public Object getByArray(Object[] keys);

    public Set<?> values(Object key1);

    public Set<?> values(Object key1, Object key2);

    public Set<?> values(Object key1, Object key2, Object key3);

    public Set<?> values(Object key1, Object key2, Object key3, Object key4);

    public Set<?> values(Object key1, Object key2, Object key3, Object key4, Object key5);

}