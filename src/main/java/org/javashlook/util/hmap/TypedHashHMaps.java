package org.javashlook.util.hmap;

import java.util.List;
import java.util.Set;

/**
 * Implementation of typed {@link HMap}s.
 * 
 */
final class TypedHashHMaps {

    static class HashHMap2<K1, K2, V> extends HashedHMap implements HMap2<K1, K2, V> {

		private static final long serialVersionUID = -6578073289632916687L;

		@SuppressWarnings("unchecked")
        @Override
        public Set<K1> keys() {
            return (Set<K1>)map.keySet();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Set<V> values() {
            return (Set<V>)values;
        }

        @Override
        public Set<V> values(K1 key) {
            return valuesImpl(key).set();
        }

        @Override
        public void put(K1 key, V value) {
            putImpl(value, key);
        }

        @Override
        public void put(K1 key1, K2 key2, V value) {
            putImpl(value, key1, key2);
        }

        @Override
        public void putByArray(Object[] keys, V value) {
            putImpl(value, keys);
        }

        @Override
        public List<K2> getAll(K1 key) {
            return getImpl(key).list();
        }

        @Override
        public List<V> getAll(K1 key1, K2 key2) {
            return getImpl(key1, key2).list();
        }

        @Override
        public List<V> getAllByArray(Object[] keys) {
            return getImpl(keys).list();
        }

        @Override
        public K2 get(K1 key) {
            return getImpl(key).unique();
        }

        @Override
        public V get(K1 key1, K2 key2) {
            return getImpl(key1, key2).unique();
        }

        @Override
        public V getByArray(Object[] keys) {
            return getImpl(keys).unique();
        }

    }

    static class HashHMap3<K1, K2, K3, V> extends HashHMap2<K1, K2, K3> implements HMap3<K1, K2, K3, V> {

		private static final long serialVersionUID = -8455784157630202372L;

		@Override
        public void put(K1 key1, K2 key2, K3 key3, V value) {
            putImpl(value, key1, key2, key3);
        }

        @Override
        public List<V> getAll(K1 key1, K2 key2, K3 key3) {
            return getImpl(key1, key2, key3).list();
        }

        @Override
        public V get(K1 key1, K2 key2, K3 key3) {
            return getImpl(key1, key2, key3).unique();
        }

        @Override
        public Set<V> values(K1 key1, K2 key2) {
            return valuesImpl(key1, key2).set();
        }

    }

    static class HashHMap4<K1, K2, K3, K4, V> extends HashHMap3<K1, K2, K3, K4> implements HMap4<K1, K2, K3, K4, V> {

		private static final long serialVersionUID = -5697299250028252142L;

		@Override
        public void put(K1 key1, K2 key2, K3 key3, K4 key4, V value) {
            putImpl(value, key1, key2, key3, key4);
        }

        @Override
        public List<V> getAll(K1 key1, K2 key2, K3 key3, K4 key4) {
            return getImpl(key1, key2, key3, key4).list();
        }

        @Override
        public V get(K1 key1, K2 key2, K3 key3, K4 key4) {
            return getImpl(key1, key2, key3, key4).unique();
        }

        @Override
        public Set<V> values(K1 key1, K2 key2, K3 key3) {
            return valuesImpl(key1, key2, key3).set();
        }

    }

    static class HashHMap5<K1, K2, K3, K4, K5, V> extends HashHMap4<K1, K2, K3, K4, K5> implements
        HMap5<K1, K2, K3, K4, K5, V> {

		private static final long serialVersionUID = 6402841344834583325L;

		@Override
        public void put(K1 key1, K2 key2, K3 key3, K4 key4, K5 key5, V value) {
            putImpl(value, key1, key2, key3, key4, key5);
        }

        @Override
        public List<V> getAll(K1 key1, K2 key2, K3 key3, K4 key4, K5 key5) {
            return getImpl(key1, key2, key3, key4, key5).list();
        }

        @Override
        public V get(K1 key1, K2 key2, K3 key3, K4 key4, K5 key5) {
            return getImpl(key1, key2, key3, key4, key5).unique();
        }

        @Override
        public Set<V> values(K1 key1, K2 key2, K3 key3, K4 key4) {
            return valuesImpl(key1, key2, key3, key4).set();
        }

    }

}
