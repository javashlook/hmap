package org.javashlook.util.hmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Internal implementation of hash-based {@link HMap}, with linked maps.
 * 
 */
class HashedHMap implements Serializable {

	private static final long serialVersionUID = -979104885286205414L;

	private static final HashedHMap EMPTY = new HashedHMap();

    final Map<Object, HashedHMap> map = new LinkedHashMap<Object, HashedHMap>();
    final Set<Object> values = new LinkedHashSet<Object>();

    static final class Result {
        final Object[] keys;
        final Set<Object> set = new LinkedHashSet<Object>();

        Result(Object... keys) {
            this.keys = keys;
        }

        void addAll(Collection<? extends Object> coll) {
            set.addAll(coll);
        }

        // using ad-hoc type parameter <V> to avoid explicit casting in typed implementations

        @SuppressWarnings("unchecked")
        <V> List<V> list() {
            return new ArrayList<V>((Set<V>)set);
        }

        @SuppressWarnings("unchecked")
        <V> Set<V> set() {
            return new LinkedHashSet<V>((Set<V>)set);
        }

        @SuppressWarnings("unchecked")
        <V> V unique() {
            try {
                return (V)IterableHelper.unique(set, null);
            }
            catch (IllegalStateException e) {
                throw new IllegalStateException("Multiple elements found for key: " + Arrays.asList(keys));
            }
        }
    }

    enum ResultCallback {
        /**
         * Puts current {@link HashedHMap} keys into result.
         */
        GET {
            @Override
            void on(Result result, HashedHMap curr) {
                result.addAll(curr.map.keySet());
            }
        },

        /**
         * Recursively collects all values (keys mapped to {@link #EMPTY}) from given {@link HashedHMap}.
         */
        VALUES {
            @Override
            void on(Result result, HashedHMap curr) {
                Map<?, HashedHMap> map = curr.map;
                for (HashedHMap next : map.values()) {
                    if (next == EMPTY) {
                        result.addAll(map.keySet());
                    }
                    else {
                        VALUES.on(result, next);
                    }
                }
            }
        };

        abstract void on(Result result, HashedHMap curr);
    }

    Result getImpl(Object... keys) {
        return getWithCallback(this, 0, keys, new Result(keys), ResultCallback.GET);
    }

    Result valuesImpl(Object... keys) {
        return getWithCallback(this, 0, keys, new Result(keys), ResultCallback.VALUES);
    }

    private Result getWithCallback(HashedHMap curr, int index, Object[] keys, Result result, ResultCallback callback) {
        Map<?, HashedHMap> map = curr.map;

        int n = (keys != null) ? keys.length : 0;

        for (int i = index; i < n; i++) {
            Object key = keys[i];

            // null in a key selects all lower level maps recursively
            if (key == null) {
                for (HashedHMap next : map.values()) {
                    getWithCallback(next, i + 1, keys, result, callback);
                }
            }

            curr = map.get(key);
            if (curr == null) {
                return result;
            }

            map = curr.map;
        }

        callback.on(result, curr);
        return result;
    }

    void putImpl(Object value, Object... keys) {
        putImpl(this, value, keys);
    }

    private void putImpl(HashedHMap curr, Object value, Object[] keys) {
        Map<Object, HashedHMap> map = curr.map;

        for (Object key : keys) {
            curr = map.get(key);

            if (curr == null) {
                curr = new HashedHMap();
                map.put(key, curr);
            }

            map = curr.map;
        }

        if (map != null) {
            map.put(value, EMPTY);
            values.add(value);
        }
    }

    @Override
    public String toString() {
        if (EMPTY == this) {
            return "[EMPTY]";
        }
        return map.toString();
    }

}