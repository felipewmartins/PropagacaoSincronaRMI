import io.github.felipewmartins.enums.ReplicaUtil;
import io.github.felipewmartins.task.Compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClienteMain {

  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("127.0.0.1",ReplicaUtil.REPLICA1.getPorta());
      Compute bc = (Compute) registry.lookup(ReplicaUtil.REPLICA1.name());
      
      Cliente felipe = new Cliente("Felipe");
      
      System.out.println("Deposito saldo:" + bc.executeTask(felipe.depositar(100)));
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
