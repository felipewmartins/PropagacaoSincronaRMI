package io.github.felipewmartins.enums;

public enum ReplicaUtil {
  REPLICA1, REPLICA2;
  
  ReplicaUtil(){
    
  }
  
  public int getPorta(){
    return ordinal() + 1099;
  }
}
