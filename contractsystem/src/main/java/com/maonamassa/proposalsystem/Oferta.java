package com.maonamassa.proposalsystem;

import com.maonamassa.usersystem.Contratante;
import com.maonamassa.usersystem.Profissional;

public class Oferta {

    Profissional profissional;

    Contratante contratante;

    private String descrição;

    private String valor;

    private StatusOfertaDemanda status;

    public Oferta(Profissional profissional, Contratante contratante, String descrição, String valor, StatusOfertaDemanda status) {
        this.profissional = profissional;
        this.contratante = contratante;
        this.descrição = descrição;
        this.valor = valor;
        this.status = status;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public String getDescrição() {
        return descrição;
    }

    public String getValor() {
        return valor;
    }

    public StatusOfertaDemanda getStatus() {
        return status;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setStatus(StatusOfertaDemanda status) {
        this.status = status;
    }

}
