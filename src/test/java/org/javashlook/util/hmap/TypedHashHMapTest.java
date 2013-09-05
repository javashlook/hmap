package org.javashlook.util.hmap;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.javashlook.util.hmap.CollectionHelper.newLinkedHashSet;

import org.junit.Before;
import org.junit.Test;

public class TypedHashHMapTest {

    private HMap3<Integer, String, String, Integer> hmap;

    @Before
    public void setUp() {
        hmap = HashHMaps.create3();

        hmap.put(1, "A", "X", 10);
        hmap.put(1, "B", "X", 15);
        hmap.put(2, "C", "X", 20);
        hmap.put(3, "A", "Y", 30);
        hmap.put(3, "A", "Y", 35);

        // below not allowed in compile-time
        // hmap.put("A", 3, "L", "X");
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

        assertEquals(Integer.valueOf(20), hmap.get(2, "C", "X"));
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

        assertEquals(hmap.values(), hmap.values(null));

        // typed hmap does not allow the same signatures for values() and getAll()
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
