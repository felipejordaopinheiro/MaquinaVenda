/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class ControllerProdutoTest {
    
    private ControllerProduto ctrProd;
    Produto produto  = new Produto();

    public ControllerProdutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ctrProd = new ControllerProduto();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ControllerProduto.
     */
    @Test
    public void testCreate() {
        produto.setNome("Produto_Teste");
        produto.setPreco(1.0);
        produto.setQtd_atual(1);
        produto.setValidade("10/01/1995");
        assertEquals(true,ctrProd.create(produto));
    }

 
    /**
     * Test of update method, of class ControllerProduto.
     */
    @Test
    public void testUpdate() {
        produto.setNome("Produto_teste_atualizado");
        assertEquals(true,ctrProd.update(produto));
    }

    /**
     * Test of delete method, of class ControllerProduto.
     */
    @Test
    public void testDelete() {
        assertEquals(true, ctrProd.delete(produto));  
    }


    /**
     * Test of checkVencido method, of class ControllerProduto.
     */
    @Test
    public void testCheckVencido() {
      System.out.println("Teste do metodo: checkVencido\n");
        ControllerProduto instance = new ControllerProduto();
        List<Produto> expResult = new ArrayList<Produto>();
        Produto e = new Produto();
        
        e.setCod(5);
        e.setNome("passou");
        e.setQtd_atual(2);
        e.setPreco(4);
        e.setValidade("17/07/2016");
        expResult.add(e);
        
               
        List<Produto> result = instance.checkVencido();
        System.out.print("Codigo do Produto Esperado: " + expResult.get(0).getCod() + " \n");
        System.out.print("Codigo do Produto recebido: " + result.get(0).getCod() + "\n");
        assertEquals(expResult.get(0).getCod(), result.get(0).getCod());

    }

    /**
     * Test of removeVencido method, of class ControllerProduto.
     */
    @Test
    public void testRemoveVencido() {
       
    }

    /**
     * Test of blockVencido method, of class ControllerProduto.
     */
    @Test
    public void testBlockVencido() {
          System.out.println("Teste do metodo: blockVencido\n");
        ControllerProduto instance = new ControllerProduto();

        List<Produto> vencidos = new ArrayList<Produto>();       
        int p = instance.blockVencido();
        vencidos = instance.checkVencido();
        int bloqueados = 0;
        
        if(!vencidos.isEmpty()){
            for (int i = 0; i < vencidos.size(); i++) {
                   if(vencidos.get(i).isBloqueado() == 1){
                       bloqueados++;
                   }
            }
        }
        System.out.println("Quantidade total de bloqueados: \n" + p);
        System.out.println("Quantidade esperada de bloqueados: \n" + bloqueados);
        assertEquals(bloqueados, p);
    }
    
}