package com.example.estoque.controllers;

import com.example.estoque.controller.EstoqueController;
import com.example.estoque.domain.Produto;
import com.example.estoque.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static java.lang.reflect.Array.get;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstoqueController.class)
public class EstoqueControllerComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProdutoService produtoService;

    @Test
    public void deveRetornarStatus200() throws Exception {
        var result = mockMvc.perform(
                MockMvcRequestBuilders.get("/estoque")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        if (result.getStatus() != 200) {
            throw new Exception();
        }

    }

    @Test
    public void deveRetornarStatus400() throws Exception {
        var result = mockMvc.perform(
                MockMvcRequestBuilders.get("/estoque")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        if (result.getStatus() != 200) {
            throw new Exception();
        }

    }

    @Test
    public void deveCadastrarProdutoComSucesso() throws Exception {

        Produto produtoParaCadastrar = new Produto("Produto Teste", "Smartphone", 1500.00, 1);
        Produto produtoCadastrado = new Produto("Produto Teste", "Smartphone", 1500.00, 1);

        when(produtoService.cadastrarProduto(produtoParaCadastrar)).thenReturn(produtoCadastrado);

        var result = mockMvc.perform(
                MockMvcRequestBuilders.post("/estoque")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produtoParaCadastrar))
        ).andReturn().getResponse();

        if (result.getStatus() != 200) {
            throw new Exception();
        }

    }



}



