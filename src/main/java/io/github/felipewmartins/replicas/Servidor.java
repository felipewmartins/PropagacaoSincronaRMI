package io.github.felipewmartins.replicas;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

import io.github.felipewmartins.enums.ReplicaUtil;
import io.github.felipewmartins.task.Compute;

/**
 * 
 * @author felipe
 *
 */

public abstract class Servidor implements Compute {
  Logger logger = Logger.getLogger("io.github.felipewmartins.replicas");
  private ReplicaUtil replica;

  public Servidor(ReplicaUtil replicaUtil) {
    this.replica = replicaUtil;
  }
  
  public void start() {
    registrarRMI();
    try {
      Compute stub = (Compute) UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry(replica.getPorta());
      registry.rebind(replica.name(), stub);
      logger.info("Iniciando Servidor!");
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }

  }

  public void registrarRMI() {
    try {
      LocateRegistry.createRegistry(replica.getPorta());
      logger.warning("Registro RMI efetuado!");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
