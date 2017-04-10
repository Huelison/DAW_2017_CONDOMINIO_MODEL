/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Recurso;
import br.edu.ifsul.modelo.UnidadeCondominal;
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
public class TestePersistirAluguel {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirAluguel() {
    
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
            UnidadeCondominal uc = em.find(UnidadeCondominal.class, 3);
            Locatario l = em.find(Locatario.class, 5);

            Aluguel al = new Aluguel();
            al.setValor(500.00);
            
            Calendar contrato  = Calendar.getInstance();
            al.setInicioContrato(contrato);

            contrato  = Calendar.getInstance();
            contrato.add(Calendar.YEAR, 2);
            al.setFimContrato(contrato);

            al.setDiaVencimento(15);
            al.setUnidadecondominal(uc);
            al.setLocatario(l);

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
