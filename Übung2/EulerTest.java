import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EulerTest {
    Euler e = null;
    int testwert = 10;

    @BeforeEach
    void setUp() {
        e = new Euler();
    }

    @AfterEach
    void tearDown() {
        e = null;
    }

    @Test
    void ausrechnen() {
        assertEquals(23, e.ausrechnen(testwert), "Wert ist falsch");
    }
}