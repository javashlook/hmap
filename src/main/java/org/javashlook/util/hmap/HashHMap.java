package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * Untyped, hash-based implementation of {@link HMap}.
 * 
 */
final class HashHMap extends HashedHMap implements HMap {

    HashHMap() {}

    @Override
    public Set<Object> keys() {
        return map.keySet();
    }

    @Override
    public Set<Object> values() {
        return values;
    }

    @Override
    public Set<?> values(Object key1) {
        return valuesImpl(key1).set();
    }

    @Override
    public Set<?> values(Object key1, Object key2) {
        return valuesImpl(key1, key2).set();
    }

    @Override
    public Set<?> values(Object key1, Object key2, Object key3) {
        return valuesImpl(key1, key2, key3).set();
    }

    @Override
    public Set<?> values(Object key1, Object key2, Object key3, Object key4) {
        return valuesImpl(key1, key2, key3, key4).set();
    }

    @Override
    public Set<?> values(Object key1, Object key2, Object key3, Object key4, Object key5) {
        return valuesImpl(key1, key2, key3, key4, key5).set();
    }

    @Override
    public void put(Object key, Object value) {
        putImpl(value, key);
    }

    @Override
    public void put(Object key1, Object key2, Object value) {
        putImpl(value, key1, key2);
    }

    @Override
    public void put(Object key1, Object key2, Object key3, Object value) {
        putImpl(value, key1, key2, key3);
    }

    @Override
    public void put(Object key1, Object key2, Object key3, Object key4, Object value) {
        putImpl(value, key1, key2, key3, key4);
    }

    @Override
    public void put(Object key1, Object key2, Object key3, Object key4, Object key5, Object value) {
        putImpl(value, key1, key2, key3, key4, key5);
    }

    @Override
    public void putByArray(Object[] keys, Object value) {
        putImpl(value, keys);
    }

    @Override
    public List<?> getAll(Object key) {
        return getImpl(key).list();
    }

    @Override
    public List<?> getAll(Object key1, Object key2) {
        return getImpl(key1, key2).list();
    }

    @Override
    public List<?> getAll(Object key1, Object key2, Object key3) {
        return getImpl(key1, key2, key3).list();
    }

    @Override
    public List<?> getAll(Object key1, Object key2, Object key3, Object key4) {
        return getImpl(key1, key2, key3, key4).list();
    }

    @Override
    public List<?> getAll(Object key1, Object key2, Object key3, Object key4, Object key5) {
        return getImpl(key1, key2, key3, key4, key5).list();
    }

    @Override
    public List<?> getAllByArray(Object[] keys) {
        return getImpl(keys).list();
    }

    @Override
    public Object get(Object key) {
        return getImpl(key).unique();
    }

    @Override
    public Object get(Object key1, Object key2) {
        return getImpl(key1, key2).unique();
    }

    @Override
    public Object get(Object key1, Object key2, Object key3) {
        return getImpl(key1, key2, key3).unique();
    }

    @Override
    public Object get(Object key1, Object key2, Object key3, Object key4) {
        return getImpl(key1, key2, key3, key4).unique();
    }

    @Override
    public Object get(Object key1, Object key2, Object key3, Object key4, Object key5) {
        return getImpl(key1, key2, key3, key4, key5).unique();
    }

    @Override
    public Object getByArray(Object[] keys) {
        return getImpl(keys).unique();
    }

}
