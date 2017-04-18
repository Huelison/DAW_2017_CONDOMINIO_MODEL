/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidades;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Huelison
 */
public class TestePersistirMensalidade {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirMensalidade() {
    
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1-ModelCONDOMINIO");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testar(){
        boolean exception = false;
        try{
            Aluguel al = em.find(Aluguel.class, 2);
            
            Mensalidades m = new Mensalidades();
            m.setValor(50.00);
            Calendar data = Calendar.getInstance();
            data.add(Calendar.MONTH, 1);
            m.setVencimento(data);
            m.setValorPagamento(50.00);
            m.setDataPagamento(Calendar.getInstance());
            
            al.adicionarMensalidade(m);
    
            Mensalidades m2 = new Mensalidades();
            m2.setValor(120.00);
            data = Calendar.getInstance();
            data.add(Calendar.MONTH, 2);
            m2.setVencimento(data);
            
            al.adicionarMensalidade(m2);
            
            em.getTransaction().begin();
            em.persist(al);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false,exception);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
