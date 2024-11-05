package com.maonamassa.contractsystem;

//essa classe detalha como deve funcionar a implementação das classes Contract, LaTeXToPDFConverter e NumeroPorExtenso
public class App {
    public static void main(String[] args) {
        
        //aqui é criado um contrato com as informações do contratante, do profissional,
        //a descrição detalhada do serviço e o valor combinado
        Contract contrato = new Contract("Lucas", 
        "123.456.789-00", 
        "Itajuba", 
        "Julia", 
        "123.456.789-00", 
        "Itajuba", 
        "construção de uma casinha amarela de cachorro de dois andares para o cachorro Toddy, no quintal da casa de Lucas", 
        "1234.56");

        LaTeXToPDFConverter converter = new LaTeXToPDFConverter();

        converter.convertToPDF(contrato);

    }
}


