package com.maonamassa.projectsystem;

import java.time.LocalDate;

public class AppProject {

    public static void main(String[] args) {
        Project projeto = new Project();
        projeto.setNomeProjeto("Projeto 1");
        projeto.setTipoServico("Desenvolvimento de software");
        projeto.setDescricaoProjeto("Descrição do projeto 1");
        projeto.setDataInicio(LocalDate.of(2024, 11, 10));
        projeto.setDataFim(LocalDate.of(2024, 12, 10));
        projeto.setValorCombinado("1234.56");
        
        System.out.println("ID do projeto: " + projeto.getId());
        System.out.println("Nome do projeto: " + projeto.getNomeProjeto());
        System.out.println("Tipo de serviço: " + projeto.getTipoServico());
        System.out.println("Descrição do projeto: " + projeto.getDescricaoProjeto());
        System.out.println("Data de início: " + projeto.getDataInicio());
        System.out.println("Data de fim: " + projeto.getDataFim());
        System.out.println("Valor combinado: " + projeto.getValorCombinado());
    }


}
