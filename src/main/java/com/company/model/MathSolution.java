package com.company.model;

import javax.validation.constraints.*;
import java.util.Objects;

public class MathSolution {

    @NotNull(message = "operand1 must be present in request")
    private Double operand1;
    @NotNull(message = "operand2 must be present in request")
    private Double operand2;
    private String operation;
    private double answer;

    public MathSolution(double operand1, double operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = calculateAnswer(operand1,operand2,operation);
    }

    public MathSolution(){
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
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
        MathSolution that = (MathSolution) o;
        return Double.compare(that.operand1, operand1) == 0 && Double.compare(that.operand2, operand2) == 0 && Double.compare(that.answer, answer) == 0 && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operation, answer);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }
}
