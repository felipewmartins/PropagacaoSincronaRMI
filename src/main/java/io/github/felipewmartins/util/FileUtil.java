package io.github.felipewmartins.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author felipe
 *
 */
public enum FileUtil {
  INSTANCE;
  
  public String read(File file){
    StringBuilder sb = new StringBuilder();
    try {
      Files.lines(file.toPath())
      .forEach(s -> sb.append(s).append(System.getProperty("line.separator")));
    } catch (Exception e) {
      // TODO: handle exception
    }
    return null;
  }
  
  public void write(File file, String text){
    try {
      Files.write(file.toPath(), text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}
