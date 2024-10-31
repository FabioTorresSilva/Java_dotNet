package org.upskill;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class QuadroTest {

    @Test
    void getAnoCriacao() {
        System.out.println("getAnoCriacao");

        Quadro instance = new Quadro("aaa", "Luis", 121);
        int expResult = 121;
        int result = instance.getAnoCriacao();
        assertEquals(expResult, result);
    }

    @Test
    void getNomeAutor() {
    }

    @Test
    void getDesignacao() {
    }

    @Test
    void setNomeAutor() {
    }

    @Test
    void setDesignacao() {
    }

    @Test
    void setAnoCriacao() {
    }

    @Test
    void testEquals() {
    }


    @Test
    void compareTo() {
    }
}