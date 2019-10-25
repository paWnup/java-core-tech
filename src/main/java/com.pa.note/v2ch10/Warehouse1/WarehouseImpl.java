package com.pa.note.v2ch10.Warehouse1;

import com.pa.note.v2ch10.Activation.Warehouse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the implementation for the remote Warehouse interface.
 *
 * @author Cay Horstmann
 * @version 1.0 2007-10-09
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {
    public WarehouseImpl() throws RemoteException {
        prices = new HashMap<String, Double>();
        prices.put("Blackwell Toaster", 24.95);
        prices.put("ZapXpress Microwave Oven", 49.95);
    }

    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return price == null ? 0 : price;
    }

    private Map<String, Double> prices;
}
