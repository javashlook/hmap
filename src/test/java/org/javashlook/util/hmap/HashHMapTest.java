package org.javashlook.util.hmap;

import static java.util.Arrays.*;
import static org.javashlook.util.hmap.CollectionHelper.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HashHMapTest {

    private HMap hmap;

    @Before
    public void setUp() {
        hmap = HashHMaps.create();

        hmap.put(1, "A", "X", 10);
        hmap.put(1, "B", "X", 15);
        hmap.put(2, "C", "X", 20);
        hmap.put(3, "A", "Y", 30);
        hmap.put(3, "A", "Y", 35);
    }

    @Test
    public void testKeysAndValues() {
        assertEquals(newLinkedHashSet(1, 2, 3), hmap.keys());
        assertEquals(newLinkedHashSet(10, 15, 20, 30, 35), hmap.values());
    }

    @Test
    public void testGetAndGetAll() {
        assertEquals(asList("A", "B", "C"), hmap.getAll(null));

        assertEquals(asList("A", "B"), hmap.getAll(1));
        assertEquals(asList(10, 15), hmap.getAll(1, null, "X"));
        assertEquals(asList("X", "Y"), hmap.getAll(null, null));
        assertEquals(asList(10, 15, 20), hmap.getAll(null, null, "X"));
        assertEquals(asList(30, 35), hmap.getAll(null, null, "Y"));
        assertEquals(asList(10, 15, 20, 30, 35), hmap.getAll(null, null, null));

        assertEquals(20, hmap.get(2, "C", "X"));
        assertEquals(asList(20), hmap.getAll(2, "C", "X"));

        assertNull(hmap.get(3, "D", "Y"));
        assertEquals(asList(30, 35), hmap.getAll(3, "A", "Y"));

        assertTrue(hmap.getAll(4).isEmpty());
        assertNull(hmap.get(4));
    }

    @Test
    public void testValues() {
        assertEquals(newLinkedHashSet(10, 15), hmap.values(1));
        assertEquals(newLinkedHashSet(20), hmap.values(2));
        assertEquals(newLinkedHashSet(30, 35), hmap.values(3));

        assertEquals(newLinkedHashSet(10), hmap.values(1, "A"));
        assertEquals(newLinkedHashSet(15), hmap.values(1, "B"));
        assertEquals(newLinkedHashSet(20), hmap.values(2, "C"));
        assertEquals(newLinkedHashSet(30, 35), hmap.values(3, "A"));

        assertEquals(newLinkedHashSet(10, 30, 35), hmap.values(null, "A"));
        assertEquals(newLinkedHashSet(10, 15, 20, 30, 35), hmap.values(null, null));
        assertEquals(newLinkedHashSet(10), hmap.values(1, "A", "X"));
        assertEquals(newLinkedHashSet(10, 15), hmap.values(1, null, "X"));

        assertEquals(newArrayList(hmap.values(1, "A", "X")), hmap.getAll(1, "A", "X"));
        // ...
        assertEquals(newArrayList(hmap.values(3, "A", "Y")), hmap.getAll(3, "A", "Y"));
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalGet() throws Exception {
        assertNotNull(hmap.get(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalMultiGet() throws Exception {
        assertNotNull(hmap.get(3, "A", "Y"));
    }

}
