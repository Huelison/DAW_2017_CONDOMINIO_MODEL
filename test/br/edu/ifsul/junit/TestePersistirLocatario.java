/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Locatario;
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
public class TestePersistirLocatario {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirLocatario() {
    
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
            Locatario l = new Locatario();
            l.setCpf("49816150000");
            l.setEmail("teste@hotmail.com");
            l.setNome("Teste");
            l.setTelefone("99 99999999");
            l.setRenda(1000.00);
            l.setLocalTrabalho("Em casa");
            l.setTelefoneTrabalho("99 99599955");
            em.getTransaction().begin();
            em.persist(l);
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
