package com.maonamassa.contractsystem;

public class ContractSystem {

    private String nomeContratante;
    private String cpfCnpjContratante;
    private String enderecoContratante;
    private String nomeProfissional;
    private String cpfCnpjProfissional;
    private String enderecoProfissional;
    private String descricaoDetalhada;
    private String valorCombinado;

    public ContractSystem(String nomeContratante, String cpfCnpjContratante, String enderecoContratante,
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

    //gets and sets
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

    public void setNomeContratante(String nomeContratante) {
        this.nomeContratante = nomeContratante;
    }

    public void setCpfCnpjContratante(String cpfCnpjContratante) {
        this.cpfCnpjContratante = cpfCnpjContratante;
    }

    public void setEnderecoContratante(String enderecoContratante) {
        this.enderecoContratante = enderecoContratante;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public void setCpfCnpjProfissional(String cpfCnpjProfissional) {
        this.cpfCnpjProfissional = cpfCnpjProfissional;
    }

    public void setEnderecoProfissional(String enderecoProfissional) {
        this.enderecoProfissional = enderecoProfissional;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public void setValorCombinado(String valorCombinado) {
        this.valorCombinado = valorCombinado;
    }

}
