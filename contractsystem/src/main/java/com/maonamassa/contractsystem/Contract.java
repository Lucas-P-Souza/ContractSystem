package com.maonamassa.contractsystem;

//essa classe representa um contrato entre um contratante e um profissional
//ela contém informações sobre o contratante, o profissional, a descrição detalhada do serviço e o valor combinado
//ela é usada para gerar um contrato em PDF
public class Contract {

    //variáveis que armazenam as informações do contrato
    private String nomeContratante;
    private String cpfCnpjContratante;
    private String enderecoContratante;
    private String nomeProfissional;
    private String cpfCnpjProfissional;
    private String enderecoProfissional;
    private String descricaoDetalhada;
    private String valorCombinado;

    //construtor que recebe todas as informações do contrato
    //é ele que deve ser usado para criar um objeto do contrato
    public Contract(String nomeContratante, String cpfCnpjContratante, String enderecoContratante,
                          String nomeProfissional, String cpfCnpjProfissional, String enderecoProfissional,
                          String descricaoDetalhada, String valorCombinado) {
        this.nomeContratante = nomeContratante;
        this.cpfCnpjContratante = cpfCnpjContratante;
        this.enderecoContratante = enderecoContratante;
        this.nomeProfissional = nomeProfissional;
        this.cpfCnpjProfissional = cpfCnpjProfissional;
        this.enderecoProfissional = enderecoProfissional;
        this.descricaoDetalhada = descricaoDetalhada;
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

}
