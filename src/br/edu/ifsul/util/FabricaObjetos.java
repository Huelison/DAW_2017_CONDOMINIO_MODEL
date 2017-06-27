package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class FabricaObjetos {

    public static List<Condominio> carregaCondominios() {
        List<Condominio> lista = new ArrayList<>();
        Condominio c = new Condominio();
        c.setNome("Condominio Teste");
        c.setEndereco("Rua teste");
        c.setNumero("987");
        c.setCep("99670000");

        Pessoa p = new Pessoa();
        p.setCpf("49816150000");
        p.setEmail("teste@hotmail.com");
        p.setNome("Teste");
        p.setTelefone("99 99999999");

        UnidadeCondominal uc = new UnidadeCondominal();
        uc.setNumero("10");
        uc.setDescricao("quarto de teste");
        uc.setArea(50.0);
        uc.setNumeroQuarto(50);
        uc.setProprietario(p);
        uc.setCondominio(c);

        c.adicionarUnidadesCondominais(uc);
        c.adicionarUnidadesCondominais(uc);

        lista.add(c);
        
        Condominio c2 = new Condominio();
        c2.setNome("Condominio Teste");
        c2.setEndereco("Rua teste");
        c2.setNumero("987");
        c2.setCep("99670000");

        Pessoa p2 = new Pessoa();
        p2.setCpf("49816150000");
        p2.setEmail("teste@hotmail.com");
        p2.setNome("Teste");
        p2.setTelefone("99 99999999");

        UnidadeCondominal uc2 = new UnidadeCondominal();
        uc2.setNumero("10");
        uc2.setDescricao("quarto de teste");
        uc2.setArea(50.0);
        uc2.setNumeroQuarto(50);
        uc2.setProprietario(p2);
        uc2.setCondominio(c2);

        c2.adicionarUnidadesCondominais(uc2);
        c2.adicionarUnidadesCondominais(uc2);

        lista.add(c2);
        
        return lista;
    }

}
