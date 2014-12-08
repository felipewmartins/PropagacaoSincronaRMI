package io.github.felipewmartins.task;

import java.util.Properties;

/**
 * 
 * @author felipe
 *
 * @param <T>
 */
public interface Task<T> {
	T execute();
	void setArquivoPrinc(Properties file);
}
