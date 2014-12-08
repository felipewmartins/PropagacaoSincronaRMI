import io.github.felipewmartins.replicas.ReplicaPrimaria;
import io.github.felipewmartins.replicas.ReplicaSecundaria;
import io.github.felipewmartins.replicas.Servidor;


public class ServidorMain {

  public static void main(String[] args) {
    Servidor replica1 = new ReplicaPrimaria();
    Servidor replica2 = new ReplicaSecundaria();

    replica1.start();
    replica2.start();

  }
}
