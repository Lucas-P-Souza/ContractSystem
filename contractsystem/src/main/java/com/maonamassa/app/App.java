package com.maonamassa.app;
import java.time.LocalDate;

import com.maonamassa.contractsystem.Contract;
import  com.maonamassa.projectsystem.Project;

/**
 * Nessa classe é onde testamos o sistema e a integração entre as outras classes
 * Primeiro devemos criar um projeto e depois um contrato para enfim gerar o PDF 
 */
public class App {

    //main
    public static void main(String[] args) {
        
        Project projeto = new Project();
        projeto.setNomeProjeto("Projeto 1");
        projeto.setTipoServico("Desenvolvimento de software");
        projeto.setDescricaoProjeto("Descrição do projeto 1");
        projeto.setDataInicio(LocalDate.of(2024, 11, 10));
        projeto.setDataFim(LocalDate.of(2024, 12, 10));
        projeto.setValorCombinado("R$ 1000,00");

        Contract contrato = new Contract(projeto);
        

    }

}
