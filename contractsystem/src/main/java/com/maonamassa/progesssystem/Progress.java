package com.maonamassa.progesssystem;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Progress 
{
	private StatusProgresso status;
	private int porcentagem;
	
	// Os próximos atributos serão herdados de outras classes futuramente e essa parte do código será mudada
	private boolean contratoRequisitado;
    private boolean projetoAceito;
	private boolean contratoAssinado;
	private boolean propostaAceita;
	
	
	public StatusProgresso getStatus() {return status;}
	public void setStatus(StatusProgresso status) {this.status = status;}
	public int getPorcentagem() {return porcentagem;}
	public void setPorcentagem(int porcentagem) {this.porcentagem = porcentagem;}
	
	// gets e sets que serão excluídos depois
	public boolean isProjetoAceito() {return projetoAceito;}
	public void setProjetoAceito(boolean projetoAceito) {this.projetoAceito = projetoAceito;}
	public boolean isContratoAssinado() {return contratoAssinado;}
	public void setContratoAssinado(boolean contratoAssinado) {this.contratoAssinado = contratoAssinado;}
	public boolean isPropostaAceita() {return propostaAceita;}
	public void setPropostaAceita(boolean propostaAceita) {this.propostaAceita = propostaAceita;}
    public boolean isInformacoesInseridas() {return contratoRequisitado;}
    public void setInformacoesInseridas(boolean contratoRequisitado) {this.contratoRequisitado = contratoRequisitado;}
	
	public void calculaPorcentagem(Temporal dataInicio, Temporal dataFim) {
		LocalDate today = LocalDate.now();
		long diasDecorridos = ChronoUnit.DAYS.between(dataInicio, today);
		long diasTotais = ChronoUnit.DAYS.between(dataInicio, dataFim);
		
        if (diasTotais > 0) porcentagem = (int) (diasDecorridos / diasTotais * 100);
        else porcentagem = 0;
	}
	
	public void updateStatus(Temporal dataInicio, Temporal dataFim) {

		LocalDate today = LocalDate.now();
		
		if (propostaAceita && !projetoAceito && !contratoRequisitado && !contratoAssinado) {
            status = StatusProgresso.AGUARDANDO_INFORMACOES;
        }
		else if (propostaAceita && projetoAceito && !contratoRequisitado && !contratoAssinado) {
            status = StatusProgresso.AGUARDANDO_CONTRATO;
        }
        else if (propostaAceita && projetoAceito && contratoRequisitado && !contratoAssinado) {
            status = StatusProgresso.AGUARDANDO_ASSINATURAS;
        }
		else if (propostaAceita && projetoAceito && contratoRequisitado && contratoAssinado) {
			if (today.isBefore((ChronoLocalDate)dataInicio)) {
                status = StatusProgresso.AGUARDANDO_INCIO;
            }
			else if (today.isEqual((ChronoLocalDate)dataInicio)) {
                status = StatusProgresso.EM_ANDAMENTO;
            }
			else if (today.isAfter((ChronoLocalDate)dataInicio) && today.isBefore((ChronoLocalDate)dataFim)){
                status = StatusProgresso.EM_ANDAMENTO;
            }
			else if (today.isEqual((ChronoLocalDate)dataFim) || today.isAfter((ChronoLocalDate)dataFim)) {
                status = StatusProgresso.FINALIZADO;
            }
		}		
	}
}