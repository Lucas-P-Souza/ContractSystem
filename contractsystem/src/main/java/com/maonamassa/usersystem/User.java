package com.maonamassa.usersystem;

import java.util.List;
import java.util.UUID;

public abstract class User {

  private String id;

  private String name;

  private String email;

  private String password;

  private String phone;

  private String address;

  private List<MetodoDePagamento> pagamento;

  private Boolean logado;
    
    public static String gerarUUID() {
        return UUID.randomUUID().toString();
    }


}