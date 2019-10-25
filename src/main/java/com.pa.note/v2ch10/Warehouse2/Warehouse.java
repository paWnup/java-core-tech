package com.pa.note.v2ch10.Warehouse2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * The remote interface for a simple warehouse.
 *
 * @author Cay Horstmann
 * @version 1.0 2007-10-09
 */
public interface Warehouse extends Remote {
    double getPrice(String description) throws RemoteException;

    Product getProduct(List<String> keywords) throws RemoteException;
}
