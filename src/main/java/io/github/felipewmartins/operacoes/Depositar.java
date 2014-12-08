package io.github.felipewmartins.operacoes;

import io.github.felipewmartins.task.Task;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Properties;

public class Depositar implements Task<Double>, Serializable {

  private static final long serialVersionUID = 1L;
  
  private Properties arquivoPrinc;
  
  private String conta;
  private double valor;
  
  public Depositar(String conta, double valor) {
    this.conta = conta;
    this.valor = valor;
  }

  @Override
  public Double execute() {
    double novoSaldo = valor;
    String saldo = arquivoPrinc.getProperty(conta);

    if (saldo != null && !saldo.isEmpty()) {
        novoSaldo += Double.parseDouble(saldo);
    }

    arquivoPrinc.setProperty(conta, String.valueOf(novoSaldo));
    arquivoPrinc.setProperty("ultimaAlteracao" + conta, LocalDateTime.now().toString());
    System.out.printf("Depositado feito de %.2f na conta do(a) %s%n", valor, conta);
    return null;
  }

  @Override
  public void setArquivoPrinc(Properties arquivoPrinc) {
    this.arquivoPrinc = arquivoPrinc;
    
  }

}
