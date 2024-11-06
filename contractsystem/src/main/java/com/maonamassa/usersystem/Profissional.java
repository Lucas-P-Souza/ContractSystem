package com.maonamassa.usersystem;

public class Profissional extends User {

  public Profissional(String nome, String email, String senha, String telefone, String endereco, String areaAtuacao, String disponibilidade, String cpfCnpj) {
    super(nome, email, senha, telefone, endereco, cpfCnpj);
    this.areaAtuacao = areaAtuacao;
    this.disponibilidade = disponibilidade;
  }

  public String areaAtuacao;

  public String disponibilidade;

  public String getAreaAtuacao() {
    return areaAtuacao;
  }

  public String getDisponibilidade() {
    return disponibilidade;
  }

  public String getNome() {
    return super.getName();
  }

  public String getEmail() {
    return super.getEmail();
  }

  public String getSenha() {
    return super.getPassword();
  }

  public String getTelefone() {
    return super.getPhone();
  }

  public String getEndereco() {
    return super.getAddress();
  }

  public String getCpfCnpj() {
    return super.getCpfcnpj();
  }

  public void setNome(String nome) {
    super.setName(nome);
  }

  public void setEmail(String email) {
    super.setEmail(email);
  }

  public void setSenha(String senha) {
    super.setPassword(senha);
  }

  public void setTelefone(String telefone) {
    super.setPhone(telefone);
  }

  public void setEndereco(String endereco) {
    super.setAddress(endereco);
  }

  public void setCpfCnpj(String cpfCnpj) {
    super.setCpfcnpj(cpfCnpj);
  }

  public void setAreaAtuacao(String areaAtuacao) {
    this.areaAtuacao = areaAtuacao;
  }

  public void setDisponibilidade(String disponibilidade) {
    this.disponibilidade = disponibilidade;
  }

}