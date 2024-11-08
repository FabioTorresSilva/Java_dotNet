package org.upskill;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @org.junit.jupiter.api.Test
    void testSetDataValida() {
        Data data = new Data();
        data.setData(2023, 7, 20);
        assertEquals(2023, data.getAno());
        assertEquals(7, data.getMes());
        assertEquals(20, data.getDia());
    }

    @org.junit.jupiter.api.Test
    void testSetDataInvalida() {
        Data data = new Data();
        assertThrows(MesInvalidoException.class, () -> data.setData(2023, 13, 15));
        assertThrows(DiaInvalidoException.class, () -> data.setData(2023, 2, 30));
    }
}