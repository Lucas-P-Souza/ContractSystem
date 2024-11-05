package com.maonamassa.projectsystem;

public enum StatusProjeto {
    
    AGUARDANDO_INFORMACOES("A proposta foi aceita, e o sistema está aguardando informações"),
    AGUARDANDO_CONTRATO("As informações foram inseridas, aguardando a geração do contrato"),
    AGUARDANDO_ASSINATURAS("O contrato foi gerado, e agora está aguardando a assinatura"),
    AGUARDANDO_INCIO("Os usuários assinaram o contntrato e agora está aguardando a data de início"),
    EM_ANDAMENTO("O projeto está em andamento"),
    FINALIZADO("O projeto foi concluído pois, a data final foi atingida");

    private final String descricao;

    StatusProjeto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
