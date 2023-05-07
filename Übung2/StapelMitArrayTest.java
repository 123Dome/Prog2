import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTest {
    StapelMitArray<Integer> stapelInteger = null;
    StapelMitArray<String> stapelStrings = null;
    static int[] testwerteInteger = {1,2,3,4,5};
    static String[] testwerteStrings = {"a","b","c","d","e"};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stapelInteger = new StapelMitArray<Integer>(testwerteInteger.length);
        stapelStrings = new StapelMitArray<String>(testwerteStrings.length);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        stapelInteger = null;
        stapelStrings = null;
    }

    @org.junit.jupiter.api.Test
    void testInsertRemoveISEmpty() {
        // Test für Integer
        assertTrue(stapelInteger.isEmpty(), " Stapel muss leer sein (Integer)");
        for(int i = 0; i < testwerteInteger.length; i++){
            stapelInteger.insert(testwerteInteger[i]);
            assertEquals(testwerteInteger[i], stapelInteger.remove(), "Insert oder Remove funktioniert nicht (Integer)");
        }

        // Test für Strings
        assertTrue(stapelStrings.isEmpty(), "Stapel muss leer sein (Strings)");
        for(int i = 0; i < testwerteStrings.length; i++){
            stapelStrings.insert(testwerteStrings[i]);
            assertEquals(testwerteStrings[i], stapelStrings.remove(), "Insert oder Remove funktioniert nicht (Strings)");
        }
    }

    @Test
    void testSizeCapacity(){
        // Test für Integer
        for(int i = 0; i < testwerteInteger.length; i++) {
            stapelInteger.insert(testwerteInteger[i]);
            assertEquals(testwerteInteger.length, stapelInteger.capacity(), "Kapazität stimmt nicht (Integer)");
            assertEquals(i + 1, stapelInteger.size(), "Größe stimmt nicht (Integer)"); // i+1 weil größe immer 1 größer ist als i
        }

        // Test für Strings
        for(int i = 0; i < testwerteStrings.length; i++) {
            stapelStrings.insert(testwerteStrings[i]);
            assertEquals(testwerteStrings.length, stapelStrings.capacity(), "Kapazität stimmt nicht (Strings)");
            assertEquals(i + 1, stapelStrings.size(), "Größe stimmt nicht (Strings)"); // i+1 weil größe immer 1 größer ist als i
        }
    }

    @Test
    void testTop(){
        // Test für Integer
        for(int i = 0; i < testwerteInteger.length; i++){
            stapelInteger.insert(testwerteInteger[i]);
            assertEquals(testwerteInteger[i], stapelInteger.top(), "Oberstes Element ist falsch (Integer)");
        }

        // Test für Strings
        for(int i = 0; i < testwerteStrings.length; i++){
            stapelStrings.insert(testwerteStrings[i]);
            assertEquals(testwerteStrings[i], stapelStrings.top(), "Oberstes Element ist falsch (Strings)");
        }
    }

    @Test
    void testIllegalStateException(){
        // Test für Integer
        for(int i = 0; i < testwerteInteger.length; i++){
            stapelInteger.insert(testwerteInteger[i]);
        }
        assertThrows(IllegalStateException.class, () -> stapelInteger.insert(testwerteInteger[0]), "Falsch eingefügt (Integer)");

        // Test für Strings
        for(int i = 0; i < testwerteStrings.length; i++){
            stapelStrings.insert(testwerteStrings[i]);
        }
        assertThrows(IllegalStateException.class, () -> stapelStrings.insert(testwerteStrings[0]), "Falsch eingefügt (Strings)");
    }

    @Test
    void testNoSuchElementException(){
        // Test für Integer
        assertThrows(NoSuchElementException.class, () -> stapelInteger.remove(), "NoSuchElementException nicht geworfen nach entfernen (Integer)");
        assertThrows(NoSuchElementException.class, () -> stapelInteger.top(), "NoSuchElementException nicht geworfen nach aufrufen des 1. Elements (Integer)");

        // Test für Strings
        assertThrows(NoSuchElementException.class, () -> stapelStrings.remove(), "NoSuchElementException nicht geworfen nach entfernen (Strings)");
        assertThrows(NoSuchElementException.class, () -> stapelStrings.top(), "NoSuchElementException nicht geworfen nach aufrufen des 1. Elements (Strings)");
    }


    @Test
    void testApplyToAll(){
        for(int i = 0; i < testwerteInteger.length; i++){
            stapelInteger.insert(testwerteInteger[i]);
        }
        stapelInteger.applyToAll(wert -> wert * 2);
        assertEquals(10, stapelInteger.remove());
        assertEquals(8, stapelInteger.remove());
        assertEquals(6, stapelInteger.remove());
        assertEquals(4, stapelInteger.remove());
        assertEquals(2, stapelInteger.remove());

        for(int i = 0; i < testwerteInteger.length; i++){
            stapelInteger.insert(testwerteInteger[i]);
        }
        stapelInteger.applyToAll(wert -> wert * wert);
        assertEquals(25, stapelInteger.remove());
        assertEquals(16, stapelInteger.remove());
        assertEquals(9, stapelInteger.remove());
        assertEquals(4, stapelInteger.remove());
        assertEquals(1, stapelInteger.remove());
    }
}