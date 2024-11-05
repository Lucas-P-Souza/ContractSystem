package com.maonamassa.contractsystem;

public class NumeroPorExtenso {

    private String parteInteiraExtenso;
    private String parteDecimalExtenso;

    private static final String[] UNIDADES = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    private static final String[] DEZENAS = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
    private static final String[] DEZ_A_DEZENOVE = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    private static final String[] CENTENAS = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

    public NumeroPorExtenso(String numero) {
        String[] partes = numero.split("\\.");
        int parteInteira = Integer.parseInt(partes[0]);
        int parteDecimal = (partes.length > 1) ? Integer.parseInt(partes[1]) : 0;

        this.parteInteiraExtenso = converteParaExtenso(parteInteira);
        this.parteDecimalExtenso = (parteDecimal > 0) ? converteParaExtenso(parteDecimal) : "zero";
    }

    public String getParteInteiraExtenso() {
        return parteInteiraExtenso;
    }

    public String getParteDecimalExtenso() {
        return parteDecimalExtenso;
    }

    private static String converteParaExtenso(int numero) {
        if (numero == 0) {
            return "zero";
        } else if (numero < 10) {
            return UNIDADES[numero];
        } else if (numero < 20) {
            return DEZ_A_DEZENOVE[numero - 10];
        } else if (numero < 100) {
            return DEZENAS[numero / 10] + (numero % 10 != 0 ? " e " + UNIDADES[numero % 10] : "");
        } else if (numero < 1000) {
            return (numero == 100 ? "cem" : CENTENAS[numero / 100]) + 
                   (numero % 100 != 0 ? " e " + converteParaExtenso(numero % 100) : "");
        } else if (numero < 1000000) {
            int milhar = numero / 1000;
            int resto = numero % 1000;
            return (milhar == 1 ? "mil" : converteParaExtenso(milhar) + " mil") + 
                   (resto != 0 ? " e " + converteParaExtenso(resto) : "");
        } else {
            int milhao = numero / 1000000;
            int resto = numero % 1000000;
            return (milhao == 1 ? "um milhao" : converteParaExtenso(milhao) + " milhoes") + 
                   (resto != 0 ? " e " + converteParaExtenso(resto) : "");
        }
    }

}
