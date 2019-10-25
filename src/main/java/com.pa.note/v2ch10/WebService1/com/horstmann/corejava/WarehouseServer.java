package com.pa.note.v2ch10.WebService1.com.horstmann.corejava;

import javax.xml.ws.Endpoint;

public class WarehouseServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WebServices/warehouse", new Warehouse());
    }
}
