import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaarTest {
    Paar<Integer, String> p = null;
    Integer i = 1;
    String s = "a";

    @BeforeEach
    void setUp() {
        p = new Paar<Integer, String>(i, s);
    }

    @AfterEach
    void tearDown() {
        p = null;
    }

    @Test
    void getErstes() {
        assertEquals(i, p.getErstes(), "Erstes Element ist falsch");
    }

    @Test
    void getZweites() {
        assertEquals(s, p.getZweites(), "Zweites Element ist falsch");
    }

    @Test
    void setErstes() {
        assertEquals(i, p.setErstes(i+1), "Erstes Element wurde falsch zurückgegeben");
        assertEquals(i+1, p.getErstes(), "Erstes Element wurde falsch gesetzt");
    }

    @Test
    void setZweites() {
        assertEquals(s, p.setZweites("b"), "Zweites Element wurde falsch zurückgegeben");
        assertEquals("b", p.getZweites(), "Zweites Element wurde falsch gesetzt");
    }

    @Test
    void setBeides() {
        p.setBeides(3, "c");
        assertEquals(3, p.getErstes(), "Erstes Element falsch gesetzt");
        assertEquals("c", p.getZweites(), "Zweites Element falsch gesetzt");
    }

    @Test
    void testEquals() {
        // Test bei neuer Referenz
        Paar<Integer,String> q = new Paar<>(i, s);
        assertTrue(p.equals(q), "Equals bei neuem Objekt funktioniert nicht");

        // Test für kopierte Referenz
        Paar<Integer,String> r = q;
        assertTrue(p.equals(r), "Equals bei kopierter Referenz funktioniert nicht");
    }

    @Test
    void testToString() {
        assertEquals("(" + i + "," + s + ")", p.toString(), "ToString funktioniert nicht");
    }
}