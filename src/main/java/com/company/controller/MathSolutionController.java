package com.company.controller;

import com.company.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class MathSolutionController {

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution addOperators(@RequestBody @Valid MathSolution opStart){;
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
    public MathSolution divideOperators(@RequestBody @Valid MathSolution opStart){
        return new MathSolution(opStart.getOperand1(), opStart.getOperand2(), "divide");
    }
}

