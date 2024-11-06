package com.maonamassa.usersystem;

public class Contratante extends User {

  public Contratante(String nome, String email, String senha, String telefone, String endereco, String descricao, String cpfCnpj) {
    super(nome, email, senha, telefone, endereco, cpfCnpj);
    this.descricao = descricao;
  }

  private String descricao;

  public String getDescricao() {
    return descricao;
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

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


}