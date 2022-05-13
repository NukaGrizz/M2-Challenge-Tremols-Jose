package com.company.controller;


import com.company.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MonthController {

    @GetMapping(value = "/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month convertMonth(@PathVariable @Valid int monthNumber) throws Exception{
        if(monthNumber > 12 || monthNumber < 1){
            throw new IllegalArgumentException("PathVariable must be a number between 1 and 12");
        }
        return new Month(monthNumber);
    }

    @GetMapping(value = "/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month randomMonth(){;
        Month randoMonth = new Month(1);
        return new Month(randoMonth.randomMonthGeneration());
    }
}
