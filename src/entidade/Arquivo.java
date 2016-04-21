/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Giliard
 */
@Entity
@Table(name = "ARQUIVO")
public class Arquivo implements Serializable {
        @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOME")
    private String NOME;
    
    @Column(name = "DATA_IMPORTACAO")
    @Temporal(TemporalType.DATE)
    private Date dataImportacao;
    
    @JoinColumn(name = "EMPRESA_ID", referencedColumnName = "id")
    @ManyToOne()
    private Empresa empresa;
    
    @Column(name="STATUS")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Date getDataImportacao() {
        return dataImportacao;
    }

    public void setDataImportacao(Date dataImportacao) {
        this.dataImportacao = dataImportacao;
    }



    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
