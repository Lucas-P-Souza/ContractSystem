package com.maonamassa.usersystem;

import java.util.List;
import java.util.UUID;

public abstract class User {

  private String id;

  private String name;

  private String cpfcnpj;

  private String email;

  private String password;

  private String phone;

  private String address;

  private List<MetodoDePagamento> pagamento;

  private Boolean logado;
    
  public static String gerarUUID() {
      return UUID.randomUUID().toString();
  }

  User(String name, String email, String password, String phone, String address, String cpfcnpj) {
    this.id = gerarUUID();
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.address = address;
    this.cpfcnpj = cpfcnpj;
    this.logado = false;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCpfcnpj() {
    return cpfcnpj;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getPhone() {
    return phone;
  }

  public String getAddress() {
    return address;
  }

  public List<MetodoDePagamento> getPagamento() {
    return pagamento;
  }

  public Boolean getLogado() {
    return logado;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCpfcnpj(String cpfcnpj) {
    this.cpfcnpj = cpfcnpj;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAddress(String address) {
      this.address = address;
  }

}