package com.maonamassa.proposalsystem;

import com.maonamassa.usersystem.Contratante;
import com.maonamassa.usersystem.Profissional;

public class Demanda {

    private Profissional profissional;

    private Contratante contratante;

    private String descricao;

    private StatusOfertaDemanda status;

    public Demanda(Profissional profissional, Contratante contratante, String descricao, StatusOfertaDemanda status) {
        this.profissional = profissional;
        this.contratante = contratante;
        this.descricao = descricao;
        this.status = status;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public String getDescricao() {
        return descricao;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(StatusOfertaDemanda status) {
        this.status = status;
    }

    public void aceitarOferta() {
        this.status = StatusOfertaDemanda.PROPOSTA_ACEITA;
    }

    public void recusarOferta() {
        this.status = StatusOfertaDemanda.PROPOSTA_REJEITADA;
    }

}

