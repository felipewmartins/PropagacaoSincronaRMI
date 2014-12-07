package io.github.felipewmartins.operacoes;

import io.github.felipewmartins.task.Task;

import java.io.Serializable;

public class Depositar implements Task<Double>, Serializable {

  private static final long serialVersionUID = 1L;
  
  private String conta;
  private double valor;
  
  public Depositar(String conta, double valor) {
    this.conta = conta;
    this.valor = valor;
  }

  @Override
  public Double execute() {
    // TODO Auto-generated method stub
    return null;
  }

}
