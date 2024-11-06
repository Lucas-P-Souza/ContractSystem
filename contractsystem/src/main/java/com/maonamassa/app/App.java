package com.maonamassa.app;
import java.time.LocalDate;

import com.maonamassa.contractsystem.Contract;
import com.maonamassa.contractsystem.LaTeXToPDFConverter;
import com.maonamassa.projectsystem.Project;
import com.maonamassa.proposalsystem.Demanda;
import com.maonamassa.proposalsystem.Oferta;
import com.maonamassa.proposalsystem.StatusOfertaDemanda;
import com.maonamassa.usersystem.Profissional;
import com.maonamassa.usersystem.Contratante;

/**
 * Nessa classe é onde testamos o sistema e a integração entre as outras classes
 * Primeiro devemos criar um projeto e depois um contrato para enfim gerar o PDF 
 */
public class App {

    //main
    public static void main(String[] args) {
        
        //criando um profissional
        Profissional profissional = new Profissional("João",
                                                     "email@gmail.com", 
                                                     "123456", 
                                                     "123456789", 
                                                     "Rua 1", 
                                                     "TI", 
                                                     "Disponível", 
                                                     "123456789");


        
        //criando um contratante
        Contratante contratante = new Contratante("Maria", 
                                                  "email@hotmail.com", 
                                                  "123456", 
                                                  "987654321", 
                                                  "Rua 2", 
                                                  "Descrição", 
                                                  "123456789");



        //criando uma demanda
        Demanda demanda = new Demanda(profissional, 
                                      contratante, 
                                      "Descrição da demanda", 
                                      StatusOfertaDemanda.AGUARDANDO_ACEITACAO);



        //criando uma oferta
        Oferta oferta = new Oferta(profissional, 
                                  contratante, 
                                  "Descrição da oferta", 
                                  "1234.56", 
                                  StatusOfertaDemanda.AGUARDANDO_ACEITACAO);



        //criando um projeto com a demanda e suas especificações
        Project projetoDemanda = new Project(demanda);
        projetoDemanda.setNomeProjeto("Mamadinha");
        projetoDemanda.setTipoServico("Sexual");
        projetoDemanda.setDescricaoProjeto("Mazzeu vai mamar tudo e todos por 5 minutos");
        projetoDemanda.setDataInicio(LocalDate.now().plusDays(2));
        projetoDemanda.setDataFim(LocalDate.now().plusDays(7));
        projetoDemanda.setValorCombinado("1234.56");
        


        //criando um projeto com a oferta
        Project projetoOferta = new Project(oferta);
        projetoOferta.setNomeProjeto("Sentadinha");
        projetoOferta.setTipoServico("Sexual");
        projetoOferta.setDescricaoProjeto("Mazzeu vai sentar em todos por 5 minutos");
        projetoOferta.setDataInicio(LocalDate.now().plusDays(4));
        projetoOferta.setDataFim(LocalDate.now().plusDays(9));
        projetoOferta.setValorCombinado("6543.21"); 



        //criando um contrato com a demanda
        Contract contratoDemanda = new Contract(projetoDemanda);

        LaTeXToPDFConverter converterDemanda = new LaTeXToPDFConverter();

        converterDemanda.convertToPDF(contratoDemanda);



        //criando um contrato com a oferta
        Contract contratoOferta = new Contract(projetoOferta);

        LaTeXToPDFConverter converterOferta = new LaTeXToPDFConverter();

        converterOferta.convertToPDF(contratoOferta);
        
    }

}
