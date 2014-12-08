package io.github.felipewmartins.replicas;

import io.github.felipewmartins.enums.ReplicaUtil;
import io.github.felipewmartins.task.Compute;
import io.github.felipewmartins.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 
 * @author felipe
 *
 */

public abstract class Servidor implements Compute {
  Logger logger = Logger.getLogger("io.github.felipewmartins.replicas");
  private static final String HOME = System.getProperty("user.home");
  private ReplicaUtil replica;
  protected final String arquivoPrincPath;
  protected Properties arquivoPrinc;
  private File logFile;

  public Servidor(ReplicaUtil replicaUtil) {
    this.replica = replicaUtil;
    arquivoPrincPath = String.format("%s/%s.properties", HOME, replica.name());

    this.arquivoPrinc = FileUtil.INSTANCE.load(arquivoPrincPath);
    this.logFile = new File(String.format("%s/%s.log", HOME, replica.name()));

    if (!logFile.exists()) {
      criarAquivoLog();

    }

  }

  public void start() {
    registrarRMI();
    try {
      Compute stub = (Compute) UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry(replica.getPorta());
      registry.rebind(replica.name(), stub);
      logger.info("Servidor iniciado");
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


  private void criarAquivoLog() {
    try {
      logFile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
