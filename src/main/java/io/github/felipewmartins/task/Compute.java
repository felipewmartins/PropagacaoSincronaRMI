package io.github.felipewmartins.task;

import java.rmi.Remote;

/**
 * 
 * @author felipe
 *
 */

public interface Compute extends Remote {

	<T> T executeTask(Task<T> t); 
}
