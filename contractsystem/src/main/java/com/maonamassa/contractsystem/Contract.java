package com.maonamassa.contractsystem;

import java.time.LocalDate;
import com.maonamassa.projectsystem.Project;
import com.maonamassa.projectsystem.TipoProjeto;

//essa classe representa um contrato entre um contratante e um profissional
//ela contém informações sobre o contratante, o profissional, a descrição detalhada do serviço e o valor combinado
//ela é usada para gerar um contrato em PDF
public class Contract {

    //variáveis que armazenam as informações do contrato
    Project projeto;
    private String nomeContratante;
    private String cpfCnpjContratante;
    private String enderecoContratante;
    private String nomeProfissional;
    private String cpfCnpjProfissional;
    private String enderecoProfissional;
    private String descricaoDetalhada;
    private String valorCombinado;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    //construtor que recebe todas as informações do contrato
    //é ele que deve ser usado para criar um objeto do contrato
    public Contract(Project projeto) {
        this.projeto = projeto;
        if(projeto.getTipoProjeto() == TipoProjeto.OFERTA_DE_SERVICO) {
            this.nomeContratante = projeto.oferta.getNomeContratante();
            this.cpfCnpjContratante = projeto.oferta.getCpfCnpjContratante();
            this.enderecoContratante = projeto.oferta.getEnderecoContratante();
            this.nomeProfissional = projeto.oferta.getNomeProfissional();
            this.cpfCnpjProfissional = projeto.oferta.getCpfCnpjProfissional();
            this.enderecoProfissional = projeto.oferta.getEnderecoProfissional();
            this.descricaoDetalhada = projeto.oferta.getDescricaoDetalhada();
            this.valorCombinado = projeto.oferta.getValorCombinado();
            this.dataInicio = projeto.oferta.getDataInicio();
            this.dataFim = projeto.oferta.getDataFim();
        }
        else if(projeto.getTipoProjeto() == TipoProjeto.DEMANDA_DE_SERVICO) {
            this.nomeContratante = projeto.demanda.getNomeContratante();
            this.cpfCnpjContratante = projeto.demanda.getCpfCnpjContratante();
            this.enderecoContratante = projeto.demanda.getEnderecoContratante();
            this.nomeProfissional = projeto.demanda.getNomeProfissional();
            this.cpfCnpjProfissional = projeto.demanda.getCpfCnpjProfissional();
            this.enderecoProfissional = projeto.demanda.getEnderecoProfissional();
            this.descricaoDetalhada = projeto.demanda.getDescricaoDetalhada();
            this.valorCombinado = projeto.demanda.getValorCombinado();
            this.dataInicio = projeto.demanda.getDataInicio();
            this.dataFim = projeto.demanda.getDataFim();
        }
        
    }

    //gets para acessar as informações do contrato
    //os sets não são necessários, pois as informações do contrato são passadas no construtor e não devem ser alteradas
    public String getNomeContratante() {
        return nomeContratante;
    }

    public String getCpfCnpjContratante() {
        return cpfCnpjContratante;
    }

    public String getEnderecoContratante() {
        return enderecoContratante;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public String getCpfCnpjProfissional() {
        return cpfCnpjProfissional;
    }

    public String getEnderecoProfissional() {
        return enderecoProfissional;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public String getValorCombinado() {
        return valorCombinado;
    }

}
