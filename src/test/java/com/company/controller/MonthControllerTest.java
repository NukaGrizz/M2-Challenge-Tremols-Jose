package com.company.controller;


import com.company.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {
        // This is the standard set up method that runs before each test. It's typically used for instantiating test
        // objects. We don't have to do anything special for mockMvc since it's Autowired. We will however be using
        // setUp() in the future.
    }

    @Test
    public void shouldConvertMonthAndReturnStatus200() throws Exception {
        Month outputMonth = new Month(1);
        outputMonth.setNumber(1);
        outputMonth.setName("January");

        String jsonOutput = mapper.writeValueAsString(outputMonth);

        mockMvc.perform(get("/month/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(jsonOutput));
    }

    @Test
    public void  shouldReturnIllegalArgumentExceptionAndStatus422ForNumberOutsideRange() throws Exception{
        mockMvc.perform(get("/month/0"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorMsg").value("PathVariable must be a number between 1 and 12"))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    public void shouldReturnRandomMonthAndStatus200() throws Exception {
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.number").exists());
    }


}