/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoblackjack.controller;

import jogoblackjack.model.Jogador;
import jogoblackjack.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danco
 */
public class ControllerArquivoTest {
    
    public ControllerArquivoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writer method, of class ControllerArquivo.
     */
    @Test
    public void testWriter() {
        System.out.println("writer");
        Jogador jogador = null;
        ControllerArquivo instance = new ControllerArquivo();
        instance.writer(jogador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reader method, of class ControllerArquivo.
     */
    @Test
    public void testReader() {
        System.out.println("reader");
        ControllerArquivo instance = new ControllerArquivo();
        LinkedList expResult = null;
        LinkedList result = instance.reader();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
