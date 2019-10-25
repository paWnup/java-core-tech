package com.pa.note.v2ch10.WebService1.com.horstmann.corejava;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the implementation for a Warehouse web service
 *
 * @author Cay Horstmann
 * @version 1.0 2007-10-09
 */

@WebService
public class Warehouse {
    public Warehouse() {
        prices = new HashMap<String, Double>();
        prices.put("Blackwell Toaster", 24.95);
        prices.put("ZapXpress Microwave Oven", 49.95);
    }

    public double getPrice(@WebParam(name = "description") String description) {
        Double price = prices.get(description);
        return price == null ? 0 : price;
    }

    private Map<String, Double> prices;
}
