package io.github.felipewmartins.task;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author felipe
 *
 */

public interface Compute extends Remote {

	<T> T executeTask(Task<T> t) throws RemoteException; 
}
