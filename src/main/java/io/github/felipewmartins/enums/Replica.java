package io.github.felipewmartins.enums;

public enum Replica {
  REPLICA1, REPLICA2;
  
  Replica(){
    
  }
  
  public int getPorta(){
    return ordinal() + 1099;
  }
}
