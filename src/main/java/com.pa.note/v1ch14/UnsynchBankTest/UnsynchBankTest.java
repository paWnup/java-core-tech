package com.pa.note.v1ch14.UnsynchBankTest;

/**
 * This program shows data corruption when multiple threads access a data structure.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-08-01
 */
public class UnsynchBankTest {
    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
}

