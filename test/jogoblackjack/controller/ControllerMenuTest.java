/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoblackjack.controller;

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
public class ControllerMenuTest {
    
    public ControllerMenuTest() {
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
     * Test of Menu method, of class ControllerMenu.
     */
    @Test
    public void testMenu() {
        System.out.println("Menu");
        ControllerMenu instance = new ControllerMenu();
        instance.Menu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarPessoa method, of class ControllerMenu.
     */
    @Test
    public void testCadastrarPessoa() {
        System.out.println("cadastrarPessoa");
        ControllerMenu instance = new ControllerMenu();
        instance.cadastrarPessoa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaJogadores method, of class ControllerMenu.
     */
    @Test
    public void testListaJogadores() {
        System.out.println("listaJogadores");
        ControllerMenu instance = new ControllerMenu();
        instance.listaJogadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarPartida method, of class ControllerMenu.
     */
    @Test
    public void testIniciarPartida() {
        System.out.println("iniciarPartida");
        ControllerMenu instance = new ControllerMenu();
        instance.iniciarPartida();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
