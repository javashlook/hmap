package org.javashlook.util.hmap;

import org.javashlook.util.hmap.TypedHashHMaps.HashHMap2;
import org.javashlook.util.hmap.TypedHashHMaps.HashHMap3;
import org.javashlook.util.hmap.TypedHashHMaps.HashHMap4;
import org.javashlook.util.hmap.TypedHashHMaps.HashHMap5;

/**
 * Factory methods for hash based {@link HMap}s, untyped and typed.
 * 
 */
public class HashHMaps {

    public static HMap create() {
        return new HashHMap();
    }

    public static <K1, K2, V> HMap2<K1, K2, V> create2() {
        return new HashHMap2<K1, K2, V>();
    }

    public static <K1, K2, K3, V> HMap3<K1, K2, K3, V> create3() {
        return new HashHMap3<K1, K2, K3, V>();
    }

    public static <K1, K2, K3, K4, V> HMap4<K1, K2, K3, K4, V> create4() {
        return new HashHMap4<K1, K2, K3, K4, V>();
    }

    public static <K1, K2, K3, K4, K5, V> HMap5<K1, K2, K3, K4, K5, V> create5() {
        return new HashHMap5<K1, K2, K3, K4, K5, V>();
    }

}
