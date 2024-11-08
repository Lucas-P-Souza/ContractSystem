package com.maonamassa.contractsystem;

//importa os itens necessários para a classe
//BufferedReader é uma classe que lê o texto de um fluxo de entrada de caracteres, armazenando em buffer para fornecer uma leitura eficiente de caracteres, arrays e linhas
//FileOutputStream é uma classe que grava bytes em um arquivo
//IOException é uma exceção que indica que ocorreu uma exceção de E/S de algum tipo
//InputStreamReader é uma classe que lê bytes e os decodifica em caracteres usando um conjunto de caracteres
//OutputStreamWriter é uma classe que grava caracteres em um fluxo de saída de bytes

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//essa classe gerencia a conversão de um arquivo LaTeX para um arquivo PDF
//ela é resposável por gerar os contratos em formato .pdf
//por motivos de problemas na implementação, o código em latex foi inserido diretamente na classe
public class LaTeXToPDFConverter {

    private String valor_inteiro;
    private String valor_decimal;

    public void convertToPDF(Contract contrato) {

        // Obtém o diretório atual da classe
        String currentDir = System.getProperty("user.dir");

        // Define o conteúdo do .tex diretamente como string
        String content = """
            \\documentclass[a4paper,12pt]{article}
            \\usepackage[utf8]{inputenc}
            \\usepackage[brazil]{babel}
            \\usepackage{amsmath}
            \\usepackage{geometry}
            \\usepackage{fancyhdr}
            \\usepackage{setspace}
            \\usepackage{titlesec}
            \\usepackage{parskip}
            \\usepackage{multicol}
            \\usepackage{xcolor}
            \\usepackage{enumitem}

            % Configurações de margem e espaçamento
            \\geometry{left=3cm, right=3cm, top=2.5cm, bottom=2.5cm}
            \\setlength{\\parindent}{0pt}
            \\setlength{\\parskip}{1em}

            \\begin{document}
            \\large{\\textbf{CONTRATO DE PRESTAÇÃO DE SERVIÇOS}}

            \\normalsize
            Pelo presente instrumento particular, as partes abaixo qualificadas:

            \\noindent \\textbf{Contratante:} (Nome da parte contratante), inscrito(a) no CPF/CNPJ sob o n.º (numero do CPF/CNPJ), com sede/residência à (endereco).

            \\noindent \\textbf{Contratado:} (Nome da parte contratada), inscrito(a) no CPF/CNPJ sob o n.º (numero do CPF/CNPJ), com sede/residência à (endereco).

            \\noindent Resolvem celebrar o presente Contrato de Prestação de Serviços, nos termos dos artigos 593 a 607 do Código Civil Brasileiro, conforme as cláusulas e condições a seguir
            \\vspace{0.5cm}

            \\large{\\textbf{Cláusula 1ª – Objeto do Contrato}}
            \\normalsize

            O presente contrato tem como objeto a prestação dos seguintes serviços: (descrever detalhadamente os serviços a serem prestados), conforme especificações constantes no Anexo I (se houver).

            \\textbf{1.1} No presente contrato o (s)  Contratado (s) obriga-se a prestar ao (à) Contratante o serviço descrito no capítulo, sem subordinação, mediante remuneração.
            
            \\newpage

            \\large{\\textbf{Cláusula 2ª – Duração do Contrato}}
            \\normalsize

            Este contrato terá vigência de 12 meses a contar da data de assinatura do presente instrumento, podendo ser renovado ou prorrogado mediante acordo entre as partes.\\\\
            \\textcolor{red}{(Art. 598 do Código Civil - Limite de Duração: se o contrato não tiver prazo determinado, qualquer uma das partes pode resolvê-lo, mediante aviso prévio.)}

            \\large{\\textbf{Cláusula 3ª – Remuneração}}
            \\normalsize

            Pela prestação dos serviços descritos na Cláusula 1ª, o(a) Contratante pagará ao(à) Contratado(a) a quantia de R\\$ valor_cheio (valor_inteiro reais e valor_decimal centavos), a ser paga da seguinte forma: (detalhar condições de pagamento, datas, forma de pagamento).

            \\large{\\textbf{Cláusula 4ª – Obrigações das Partes}}
            \\normalsize

            \\textbf{4.1 Obrigações do Contratado}\\\\ 
            O(a) Contratado(a) obriga-se a:
            \\begin{enumerate}[label=\\alph*)]
                \\item Prestar os serviços objeto deste contrato com a devida diligência, qualidade e nos prazos estabelecidos, utilizando-se de boas práticas do setor e observando todas as normas técnicas e legais aplicáveis;
                \\item Utilizar produtos e materiais de qualidade, de procedência legal e devidamente regulamentados pelos órgãos competentes, assegurando a conformidade com todas as legislações vigentes, especialmente aquelas relativas à segurança e ao meio ambiente;
                \\item Fornecer relatórios periódicos sobre o andamento dos serviços, conforme solicitado pelo(a) Contratante, detalhando o progresso das atividades, eventuais dificuldades encontradas e previsões de conclusão;
                \\item Arcar com todos os tributos, encargos trabalhistas, previdenciários, securitários e demais responsabilidades legais relacionadas à sua equipe ou subcontratados envolvidos na execução dos serviços;
                \\item Manter sigilo sobre todas as informações, documentos, dados técnicos, comerciais ou confidenciais recebidos ou acessados durante a execução dos serviços, comprometendo-se a não divulgá-los a terceiros sem prévia autorização por escrito do(a) Contratante;
                \\item Reparar quaisquer danos causados ao patrimônio do(a) Contratante ou a terceiros, decorrentes de conduta culposa ou dolosa durante a execução dos serviços;
                \\item Cumprir as normas de segurança e higiene no local da prestação dos serviços, assumindo total responsabilidade por acidentes de trabalho ou outros eventos decorrentes de sua atuação;
                \\item Não subcontratar, transferir ou ceder a terceiros a execução dos serviços objeto deste contrato sem a prévia e expressa autorização do(a) Contratante, exceto em casos expressamente autorizados neste instrumento.
            \\end{enumerate}

            \\textbf{4.2 Obrigações do Contratante}\\\\ 
            O(a) Contratante obriga-se a:
            \\begin{enumerate}[label=\\alph*)]
                \\item Pagar a remuneração estipulada nas condições acordadas, pontualmente e de acordo com os prazos estabelecidos neste contrato, sob pena de aplicação de juros e correção monetária em caso de inadimplência;
                \\item Fornecer ao(à) Contratado(a) todas as informações, documentos, materiais e condições necessárias para a adequada execução dos serviços, inclusive autorizações, licenças e quaisquer requisitos exigidos por autoridades competentes;
                \\item Dar suporte técnico e administrativo sempre que necessário para o bom andamento dos trabalhos, inclusive facilitando o acesso do(a) Contratado(a) às instalações e equipamentos necessários à prestação dos serviços;
                \\item Manter sigilo sobre quaisquer informações confidenciais, técnicas, comerciais ou estratégicas fornecidas pelo(a) Contratado(a), comprometendo-se a não divulgá-los a terceiros sem prévia autorização por escrito do(a) Contratado(a);
                \\item Colaborar com o(a) Contratado(a), abstendo-se de praticar qualquer ato que possa prejudicar ou atrasar a execução dos serviços;
                \\item Comunicar prontamente ao(à) Contratado(a) qualquer fato que possa interferir no curso dos trabalhos, especialmente modificações de escopo, condições de execução ou dificuldades de acesso às áreas onde os serviços serão realizados;
                \\item Facilitar o cumprimento das normas de segurança e saúde ocupacional durante a execução dos serviços, informando o(a) Contratado(a) sobre eventuais riscos existentes nas instalações ou no ambiente de trabalho.
            \\end{enumerate}

            \\large{\\textbf{Cláusula 5ª – Rescisão}}
            \\normalsize

            O presente contrato poderá ser rescindido, de pleno direito, nas seguintes hipóteses:
            \\begin{enumerate}[label=\\alph*)]
                \\item Pelo descumprimento de qualquer das cláusulas estabelecidas, por qualquer das partes;
                \\item Por interesse de qualquer uma das partes, mediante aviso prévio com antecedência mínima de (indicar o prazo), conforme o art. 599 do Código Civil.
            \\end{enumerate}

            \\large{\\textbf{Cláusula 6ª – Alterações no Contrato}}
            \\normalsize

            Quaisquer alterações no presente contrato deverão ser formalizadas por meio de termo aditivo, assinado por ambas as partes.

            \\large{\\textbf{Cláusula 7ª – Taxa de serviços}}
            \\normalsize

            As partes contratantes estão cientes de que a plataforma aplica uma taxa de administração e intermediação de [inserir valor da porcentagem]\\% sobre o valor total do serviço contratado, destinada a cobrir os custos operacionais e de manutenção da plataforma. Essa taxa será cobrada mensalmente do prestador de serviços acerca dos pagamentos realizados pela parte contratante a ele, e é considerada não-reembolsável pela plataforma.

            \\large{\\textbf{Cláusula 8ª – Interrupção por Força Maior}}
            \\normalsize

            Nenhuma das partes será responsabilizada por qualquer falha ou atraso no cumprimento de suas obrigações contratuais decorrentes de eventos que estejam fora de seu controle razoável. Tais eventos incluem, mas não se limitam a, desastres naturais, guerras, atos de terrorismo, epidemias, crises sanitárias, ou qualquer outra situação que impossibilite a execução normal do contrato. A parte que se encontrar em uma situação de força maior deverá notificar a outra parte sobre a ocorrência do evento o mais rapidamente possível, especificando a natureza do evento e suas consequências no cumprimento do contrato.

            \\large{\\textbf{Cláusula 9ª – Propriedade Intelectual}}
            \\normalsize

            As partes reconhecem que todos os direitos de propriedade intelectual relacionados a criações, produtos ou serviços gerados durante a utilização da plataforma pertencem à parte que os desenvolveu. Isso inclui, mas não se limita a, direitos autorais, patentes, marcas e segredos comerciais. A parte que utiliza tais criações ou serviços concorda em respeitar os direitos de propriedade intelectual da outra parte e não poderá reproduzir, distribuir, ou modificar tais criações sem o consentimento prévio por escrito da parte titular dos direitos. Ambas as partes concordam em cooperar para proteger e defender esses direitos, inclusive notificando qualquer uso não autorizado detectado.

            \\vspace{2cm}
            \\textbf{Local e Data:}

            \\vspace{1cm}
            \\begin{multicols}{2}
            \\textbf{Contratante:} \\\\ \\hrulefill
            \\vspace{1cm}
            \\textbf{Contratado:} \\\\ \\hrulefill
            \\end{multicols}
            \\end{document}
            """;


        // Substitui os placeholders pelas variáveis
        NumeroPorExtenso numero = new NumeroPorExtenso(contrato.getValorCombinado());
        valor_inteiro = numero.getParteInteiraExtenso();
        valor_decimal = numero.getParteDecimalExtenso();

        content = content.replace("(Nome da parte contratante)", contrato.getNomeContratante())
                         .replace("(numero do CPF/CNPJ)", contrato.getCpfCnpjContratante())
                         .replace("(endereco)", contrato.getEnderecoContratante())
                         .replace("(Nome da parte contratada)", contrato.getNomeProfissional())
                         .replace("(numero do CPF/CNPJ)", contrato.getCpfCnpjProfissional())
                         .replace("(endereco)", contrato.getEnderecoProfissional())
                         .replace("(descrever detalhadamente os serviços a serem prestados)", contrato.getDescricaoDetalhada())
                         .replace("valor_cheio", contrato.getValorCombinado())
                         .replace("valor_inteiro", valor_inteiro)
                         .replace("valor_decimal", valor_decimal);

        // Cria um novo arquivo .tex modificado
        String modifiedFileName = currentDir + File.separator + contrato.getId()+ "contrato_final.tex";
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(modifiedFileName), "UTF-8")) {
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
