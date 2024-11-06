package com.maonamassa.contractsystem;

import java.time.LocalDate;
import java.util.UUID;

import com.maonamassa.projectsystem.Project;
import com.maonamassa.projectsystem.TipoProjeto;

//essa classe representa um contrato entre um contratante e um profissional
//ela contém informações sobre o contratante, o profissional, a descrição detalhada do serviço e o valor combinado
//ela é usada para gerar um contrato em PDF
public class Contract {

    //variáveis que armazenam as informações do contrato
    Project projeto;
    String id;
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
            this.id = gerarUUID();
            this.nomeContratante = projeto.getOferta().getContratante().getNome();
            this.cpfCnpjContratante = projeto.getOferta().getContratante().getCpfcnpj();
            this.enderecoContratante = projeto.getOferta().getContratante().getEndereco();
            this.nomeProfissional = projeto.getOferta().getProfissional().getNome();
            this.cpfCnpjProfissional = projeto.getOferta().getProfissional().getCpfcnpj();
            this.enderecoProfissional = projeto.getOferta().getProfissional().getEndereco();
            this.descricaoDetalhada = projeto.getDescricaoProjeto();
            this.valorCombinado = projeto.getOferta().getValor().toString();
            this.dataInicio = projeto.getDataInicio();
            this.dataFim = projeto.getDataFim();
        }
        else if(projeto.getTipoProjeto() == TipoProjeto.DEMANDA_DE_SERVICO) {
            this.id = gerarUUID();
            this.nomeContratante = projeto.getDemanda().getContratante().getNome();
            this.cpfCnpjContratante = projeto.getDemanda().getContratante().getCpfcnpj();
            this.enderecoContratante = projeto.getDemanda().getContratante().getEndereco();
            this.nomeProfissional = projeto.getDemanda().getProfissional().getNome();
            this.cpfCnpjProfissional = projeto.getDemanda().getProfissional().getCpfcnpj();
            this.enderecoProfissional = projeto.getDemanda().getProfissional().getEndereco();
            this.descricaoDetalhada = projeto.getDescricaoProjeto();
            this.valorCombinado = projeto.getValorCombinado().toString();
            this.dataInicio = projeto.getDataInicio();
            this.dataFim = projeto.getDataFim();
        }
        
    }

    public static String gerarUUID() {
      return UUID.randomUUID().toString();
    }

    //aqui setamos o valor que não foi combinado na demanda
    public void setValorCombinado(String valorCombinado) {
        this.valorCombinado = valorCombinado;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Project getProjeto() {
        return projeto;
    }

    public String getId() {
        return id;
    }

}
