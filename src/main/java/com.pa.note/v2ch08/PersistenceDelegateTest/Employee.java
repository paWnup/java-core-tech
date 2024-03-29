package com.pa.note.v2ch08.PersistenceDelegateTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        // GregorianCalendar uses 0 for January
        hireDay = calendar.getTime();
    }

    public Employee(String n, double s, Date h) {
        name = n;
        salary = s;
        hireDay = h;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    private String name;
    private double salary;
    private Date hireDay;
}
