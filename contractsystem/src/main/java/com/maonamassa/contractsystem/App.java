package com.maonamassa.contractsystem;

public class App {
    public static void main(String[] args) {
        
        ContractSystem contract = new ContractSystem("Lucas", 
        "123.456.789-00", 
        "Itajuba", 
        "Julia", 
        "123.456.789-00", 
        "Itajuba", 
        "construção de uma casinha amarela de cachorro de dois andares para o cachorro Toddy, no quintal da casa de Lucas", 
        "1234.56");

        LaTeXToPDFConverter converter = new LaTeXToPDFConverter();

        converter.convertToPDF(contract.getNomeContratante(),
                              contract.getCpfCnpjContratante(),
                              contract.getEnderecoContratante(),
                              contract.getNomeProfissional(),
                              contract.getCpfCnpjProfissional(),
                              contract.getEnderecoProfissional(),
                              contract.getDescricaoDetalhada(),
                              contract.getValorCombinado());

    }
}


