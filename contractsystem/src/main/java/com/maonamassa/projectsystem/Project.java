package com.maonamassa.projectsystem;

import com.maonamassa.propostas.Demanda;
import com.maonamassa.propostas.Oferta;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Essa classe é responsável por criar o objeto projeto, que é composto por um nome, descrição, data de início, 
 * data de fim e valor combinado.
 * O método de status deve ser alterado conforme a inserção de informações do projeto, geração de contrato, assinatura, 
 * início do projeto na data prevista, andamento e finalização na data prevista.
 * O ID do projeto é gerado automaticamente, por isso não deve ser alterado.
 */

//classe responsável por criar o objeto projeto
public class Project {

    Oferta oferta;

    Demanda demanda;
    
    String id;
    
    public static String gerarUUID() {
        return UUID.randomUUID().toString();
    }

    //atributos
    private String nomeProjeto;
    private String tipoServico;
    private String descricaoProjeto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String valorCombinado;
    private TipoProjeto tipoProjeto;

    //construtor
    public Project(Oferta oferta) {
        this.id = gerarUUID();
        this.oferta = oferta;
        this.demanda = null;
        this.tipoProjeto = TipoProjeto.OFERTA_DE_SERVICO;
    }

    public Project(Demanda demanda) {
        this.id = gerarUUID();
        this.demanda = demanda;
        this.oferta = null;
        this.tipoProjeto = TipoProjeto.DEMANDA_DE_SERVICO;
    }

    // Gets e Sets dos atributos
    public String getId() {
        return id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getValorCombinado() {
        return valorCombinado;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setValorCombinado(String valorCombinado) {
        this.valorCombinado = valorCombinado;
    }
    
    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    } 

}
