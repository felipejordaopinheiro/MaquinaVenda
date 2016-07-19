/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dinheiro;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FelipeJordao
 */
public class ControllerDinheiroTest {
    List<Dinheiro> dinheiros;
    public ControllerDinheiroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                dinheiros = new ArrayList<>();
        
        Dinheiro dinheiro = new Dinheiro();
        dinheiro.setId(1);
        dinheiro.setQtd(10);
        dinheiro.setValue(0.5);
        dinheiros.add(dinheiro);
            
        Dinheiro dinheiro1 = new Dinheiro();
        dinheiro1.setId(2);
        dinheiro1.setQtd(10);
        dinheiro1.setValue(1);
        dinheiros.add(dinheiro1);
        
        Dinheiro dinheiro2 = new Dinheiro();
        dinheiro2.setId(1);
        dinheiro2.setQtd(10);
        dinheiro2.setValue(5);
        dinheiros.add(dinheiro2);
        
        Dinheiro dinheiro3 = new Dinheiro();
        dinheiro3.setId(3);
        dinheiro3.setQtd(10);
        dinheiro3.setValue(10);
        dinheiros.add(dinheiro3);
        
        
        
    }
    
    @After
    public void tearDown() {
    }

 
    /**
     * Test of calculaTroco method, of class ControllerDinheiro.
     */
    @Test
    public void testCalculaTroco() {
 System.out.println("calculaTroco");
        double totalinserido = 15.0;
        double totalproduto = 2.50;
        List<Dinheiro> dinheiros = this.dinheiros;
        ControllerDinheiro instance = new ControllerDinheiro();
        List<Double> expResult = new ArrayList();
        
        
        expResult.add(10.0);
        expResult.add(1.0);
        expResult.add(1.0);
        expResult.add(0.5);
        
        List<Double> result = instance.calculaTroco(totalinserido, totalproduto, dinheiros);
        
        while(!result.isEmpty()){
            System.out.println(result.remove(result.size() - 1));
        
        }
        
        while(!expResult.isEmpty()){
            System.out.println(expResult.remove(expResult.size() - 1));
        
        }
        assertEquals(expResult, result);
        
    
    }

    /**
     * Test of compra method, of class ControllerDinheiro.
     */
    @Test
    public void testCompra() {
          System.out.println("compra");
        Produto p = new Produto();
        p.setCod(0);
        p.setPreco(5);
        p.setQtd_atual(0);
        
        Double totaldinheiro = 1.0;
        int Status;
        ControllerDinheiro instance = new ControllerDinheiro();
        Status = instance.compra(totaldinheiro, p);
        
        assertEquals(2, Status);
        
        if(Status == 1)
            System.out.println("Quantidade esgotada");
        if(Status == 2)
            System.out.println("Dinheiro insuficiente");
            
        if(Status == 0)
            System.out.println("Produto comprado."); 
    }
    
}
