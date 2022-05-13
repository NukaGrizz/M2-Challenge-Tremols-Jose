package com.company.controller;

import com.company.model.CustomErrorResponse;
import com.company.model.MathSolution;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// code from class
@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

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

    // modified code from class
    @Test
    public void shouldAddOperatorsAndReturnStatusCode200() throws Exception {
        MathSolution outputSolution = new MathSolution();
        outputSolution.setOperand1(1.0);
        outputSolution.setOperand2(2.0);
        outputSolution.setOperation("add");
        outputSolution.setAnswer(3.0);

        String outputJson = mapper.writeValueAsString(outputSolution);

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);
        inputSolution.setOperand2(2.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isOk())               // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldFailToAddOperatorsAndReturnStatusCode422() throws Exception {

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());
    }


    // modified code from class
    @Test
    public void shouldSubtractOperatorsAndReturnStatusCode200() throws Exception {
        MathSolution outputSolution = new MathSolution();
        outputSolution.setOperand1(1.0);
        outputSolution.setOperand2(2.0);
        outputSolution.setOperation("subtract");
        outputSolution.setAnswer(-1.0);

        String outputJson = mapper.writeValueAsString(outputSolution);

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);
        inputSolution.setOperand2(2.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isOk())               // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldFailToSubtractOperatorsAndReturnStatusCode422() throws Exception {

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());
    }

    // modified  code from class
    @Test
    public void shouldMultiplyOperatorsAndReturnStatusCode200() throws Exception {
        MathSolution outputSolution = new MathSolution();
        outputSolution.setOperand1(1.0);
        outputSolution.setOperand2(2.0);
        outputSolution.setOperation("multiply");
        outputSolution.setAnswer(2.0);

        String outputJson = mapper.writeValueAsString(outputSolution);

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);
        inputSolution.setOperand2(2.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isOk())               // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldFailToMultiplytOperatorsAndReturnStatusCode422() throws Exception {

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());
    }

    // modified code from class
    @Test
    public void shouldDivideOperatorsandReutrnStatusCode200() throws Exception {
        MathSolution outputSolution = new MathSolution();
        outputSolution.setOperand1(1.0);
        outputSolution.setOperand2(2.0);
        outputSolution.setOperation("divide");
        outputSolution.setAnswer(0.5);

        String outputJson = mapper.writeValueAsString(outputSolution);

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);
        inputSolution.setOperand2(2.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isOk())               // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldFailToDivideOperatorsAndReturnStatusCode422() throws Exception {

        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1(1.0);

        String inputJson = mapper.writeValueAsString(inputSolution);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isUnprocessableEntity());
    }
}