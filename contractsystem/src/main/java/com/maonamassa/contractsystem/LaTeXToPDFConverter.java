package com.maonamassa.contractsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class LaTeXToPDFConverter {

    private String valor_inteiro;
    private String valor_decimal;

    public void convertToPDF(String nomeContratante, String cpfCnpjContratante, String enderecoContratante,
                             String nomeProfissional, String cpfCnpjProfissional, String enderecoProfissional,
                             String descricaoDetalhada, String valorCombinado) {
        // Obtém o diretório atual da classe
        String currentDir = System.getProperty("user.dir");

        // Especifica o caminho para o arquivo .tex que deve estar na mesma pasta
        File texFile = new File(currentDir + File.separator + "latex.tex");

        // Verifica se o arquivo existe
        if (!texFile.exists()) {
            System.err.println("Arquivo .tex não encontrado: " + texFile.getAbsolutePath());
            return;
        }

        // Mostra o caminho do arquivo .tex
        System.out.println("Caminho do arquivo .tex: " + texFile.getAbsolutePath());

        // Lê o conteúdo do arquivo .tex
        String content;
        try {
            content = new String(Files.readAllBytes(texFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        NumeroPorExtenso numero = new NumeroPorExtenso(valorCombinado);

        valor_inteiro = numero.getParteInteiraExtenso();
        valor_decimal = numero.getParteDecimalExtenso();

        // Substitui os placeholders pelas variáveis
        content = content.replace("(Nome da parte contratante)", nomeContratante)
                         .replace("(numero do CPF/CNPJ)", cpfCnpjContratante)
                         .replace("(endereco)", enderecoContratante)
                         .replace("(Nome da parte contratada)", nomeProfissional)
                         .replace("(numero do CPF/CNPJ)", cpfCnpjProfissional)
                         .replace("(endereco)", enderecoProfissional)
                         .replace("(descrever detalhadamente os serviços a serem prestados)", descricaoDetalhada)
                         .replace("valor_cheio", valorCombinado)
                         .replace("valor_inteiro", valor_inteiro)
                         .replace("valor_decimal", valor_decimal);

        // Cria um novo arquivo .tex modificado
        String modifiedFileName = currentDir + File.separator + "contrato_modified.tex";
        try (FileWriter writer = new FileWriter(modifiedFileName)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Comando para executar pdflatex no arquivo modificado
        String command = "pdflatex " + modifiedFileName;

        try {
            // Inicia o processo para executar o pdflatex
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Lê a saída do processo
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor(); // Aguarde a conclusão do processo
            
            if (exitCode == 0) {
                System.out.println("PDF gerado com sucesso!");
            } else {
                System.err.println("Erro na geração do PDF. Código de saída: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
