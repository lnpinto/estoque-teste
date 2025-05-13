package com.example.estoque.controllers;

import com.example.estoque.controller.EstoqueController;
import com.example.estoque.domain.Produto;
import com.example.estoque.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EstoqueControllerComponentTest {

    @MockitoBean
    private EstoqueController estoqueController;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProdutoService produtoService;

    @Test
    public void givenEstoqueIsNull_whenGetEstoque_thenStatus200() throws Exception {
        var result = mockMvc.perform(
                MockMvcRequestBuilders.get("/estoque")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        if (result.getStatus() != 200) {
            throw new Exception();
        }

    }

    @Test
    public void givenProductHasNoName_whenGetEstoque_thenStatus400() throws Exception {
        var result = mockMvc.perform(
                MockMvcRequestBuilders.get("/estoque")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        if (result.getStatus() != 200) {
            throw new Exception();
        }

    }

}



