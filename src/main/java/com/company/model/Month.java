package com.company.model;

import javax.print.DocFlavor;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class Month {

    private int number;
    private String name;

    public Month(int number) {
        this.number = number;
        this.name = convertMonth(number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String convertMonth(int number){
        switch(number) {
            case 1: return "January";
            case 2: return "Febuary";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Must be int between 1 to 12";
        }
    }

    public int randomMonthGeneration(){
        int month = (int) Math.round(1 + (Math.random() * (12 - 1)));
        return month;
    }

    public double calculateAnswer(double operand1, double operand2, String operation){
        switch(operation) {
            case "add": return operand1 + operand2;
            case "subtract": return operand1 - operand2;
            case "divide": return operand1 / operand2;
            case "multiply": return operand1 * operand2;
            default: return 0/0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return number == month.number && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
