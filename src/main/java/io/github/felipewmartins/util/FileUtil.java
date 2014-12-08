package io.github.felipewmartins.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

/**
 * 
 * @author felipe
 *
 */
public enum FileUtil {
  INSTANCE;

  public String read(File file) {
    StringBuilder sb = new StringBuilder();
    try {
      Files.lines(file.toPath()).forEach(
          s -> sb.append(s).append(System.getProperty("line.separator")));
    } catch (Exception e) {
      // TODO: handle exception
    }
    return sb.toString();
  }

  public void write(File file, String text) {
    try {
      Files.write(file.toPath(), text.getBytes(), StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }

  public Properties load(String filePath) {
    Properties prop = new Properties();
    File file = new File(filePath);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try (InputStream input = new FileInputStream(file)) {
      prop.load(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return prop;
  }

  public void write(Properties prop, String filePath) {
    try (OutputStream output = new FileOutputStream(filePath)) {
      prop.store(output, null);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
