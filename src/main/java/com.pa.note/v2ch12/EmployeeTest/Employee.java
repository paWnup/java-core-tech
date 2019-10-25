package com.pa.note.v2ch12.EmployeeTest;

/**
 * @author Cay Horstmann
 * @version 1.10 1999-11-13
 */

public class Employee {
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public native void raiseSalary(double byPercent);

    public void print() {
        System.out.println(name + " " + salary);
    }

    private String name;
    private double salary;

    static {
        System.loadLibrary("Employee");
    }
}
