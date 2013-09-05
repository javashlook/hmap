# hmap

A "hierarchical" map in Java.

## Untyped map

``org.javashlook.util.hmap.HMap``

An untyped hierarchical map.  Allows something like: 

```java
      HMap hmap = ...;
      hmap.put(1, "A", "X", 10);
      hmap.put(1, "B", "X", 15);
      hmap.put(2, "C", "X", 20);
 
      hmap.getAll(null);              // A, B, C
      
      hmap.getAll(1);                 // A, B
      hmap.getAll(1, null, "X");      // 10, 15
      hmap.get(2, "C", "X");          // 20
      hmap.getAll(null, null, "X");   // 10, 15, 20
 
      hmap.getAll(3);                 // empty
      hmap.get(3);                    // null
      hmap.get(3, "D", "Y");          // null
 
      hmap.values();                  // 10, 15, 20
      hmap.values(1);                 // 10, 14
      hmap.values(2);                 // 20
      hmap.values(1, "A");            // 10
```

## Typed maps

``org.javashlook.util.hmap.HMap2<K1, K2, V>``
``org.javashlook.util.hmap.HMap3<K1, K2, K3, V>``
``org.javashlook.util.hmap.HMap4<K1, K2, K3, K4, V>``
``org.javashlook.util.hmap.HMap5<K1, K2, K3, K4, K5, V>``

Additional typechecking is done at compile time. Wider maps inherit the narrower ones e.g.
``HMap5<K1, K2, K3, K4, K5, V> extends HMap4<K1, K2, K3, K4, K5>``

Allows something like:

```java
	private HMap3<Integer, String, String, Integer> hmap;

    hmap = HashHMaps.create3();

    hmap.put(1, "A", "X", 10);
    hmap.put(1, "B", "X", 15);
    hmap.put(2, "C", "X", 20);
    hmap.put(3, "A", "Y", 30);
    hmap.put(3, "A", "Y", 35);

    // below not allowed in compile-time
    // hmap.put("A", 3, "L", "X");
```
