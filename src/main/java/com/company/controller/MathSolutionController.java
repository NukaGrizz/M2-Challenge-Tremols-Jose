package com.company.controller;

import com.company.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

@RestController
public class MathSolutionController {

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution addOperators(@RequestBody @Valid MathSolution opStart) throws Exception{
        return new MathSolution(opStart.getOperand1(), opStart.getOperand2(), "add");
    }

    @PostMapping(value = "/subtract")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution subtractOperators(@RequestBody @Valid MathSolution opStart){
        return new MathSolution(opStart.getOperand1(), opStart.getOperand2(), "subtract");
    }

    @PostMapping(value = "/multiply")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution multiplyOperators(@RequestBody @Valid MathSolution opStart){
        return new MathSolution(opStart.getOperand1(), opStart.getOperand2(), "multiply");
    }

    @PostMapping(value = "/divide")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution divideOperators(@RequestBody @Valid MathSolution opStart) throws Exception{
        if(opStart.getOperand2() == 0){
            throw new IllegalArgumentException("Cannot divide number by zero! operand2 cannot be zero!");
        }
        return new MathSolution(opStart.getOperand1(), opStart.getOperand2(), "divide");
    }
}

