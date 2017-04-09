/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Huelison
 */
@Entity
@Table(name = "condominio")
public class Condominio implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome não pode ser em brnaco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "O endereco deve ser informado")
    @Length(max = 50, message = "O endereco não pode ter mais que {max} caracteres")
    @NotBlank(message = "O endereco não pode ser em brnaco")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    @NotNull(message = "O numero deve ser informado")
    @Length(max = 50, message = "O bairro não pode ter mais que {max} caracteres")
    @NotBlank(message = "O numero não pode ser em brnaco")
    @Column(name = "numero", length = 50, nullable = false)
    private String numero;
    @NotNull(message = "O cep deve ser informado")
    @Length(max = 9, message = "O cep não pode ter mais que {max} caracteres")
    @NotBlank(message = "O cep não pode ser em brnaco")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;    

    public Condominio() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}