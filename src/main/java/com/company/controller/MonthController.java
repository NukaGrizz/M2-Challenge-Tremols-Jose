package com.company.controller;


import com.company.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MonthController {

    @GetMapping(value = "/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month convertMonth(@PathVariable @Valid int monthNumber){
        return new Month(monthNumber);
    }

    @GetMapping(value = "/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month randomMonth(){;
        Month randoMonth = new Month(1);
        return new Month(randoMonth.randomMonthGeneration());
    }
}
