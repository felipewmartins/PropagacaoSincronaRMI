package io.github.felipewmartins.replicas;

import io.github.felipewmartins.enums.ReplicaUtil;
import io.github.felipewmartins.task.Task;

public class ReplicaPrimaria extends Servidor{

  public ReplicaPrimaria() {
    super(ReplicaUtil.REPLICA1);
  }
  
  @Override
  public <T> T executeTask(Task<T> t) {
    // TODO Auto-generated methods stub
    return null;
  }

}
