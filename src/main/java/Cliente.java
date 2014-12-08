import io.github.felipewmartins.operacoes.Depositar;


public class Cliente {

  private String conta;
  
  public Cliente(String conta) {
   this.conta = conta;
  }
  
  public Depositar depositar(double valor){
    Depositar depositar = new Depositar(conta, valor);
    return depositar;
    
  }
}
