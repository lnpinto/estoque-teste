package com.example.estoque.service;

import com.example.estoque.domain.ItemPedido;
import com.example.estoque.domain.Pedido;
import com.example.estoque.domain.Produto;
import com.example.estoque.entity.ProdutoEntity;
import com.example.estoque.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    public void deveCadastrarProdutoComSucesso(){

        Produto produtoParaCadastrar = new Produto("Produto Teste", "Smartphone", 1500.00, 1);
        ProdutoEntity produtoEntitySalvo = new ProdutoEntity();
        produtoEntitySalvo.setId(1L);
        produtoEntitySalvo.setNome(produtoParaCadastrar.getNome());
        produtoEntitySalvo.setDescricao(produtoParaCadastrar.getDescricao());
        produtoEntitySalvo.setPreco(produtoParaCadastrar.getPreco());
        produtoEntitySalvo.setQtd(produtoParaCadastrar.getQtd());

        when(produtoRepository.save(any(ProdutoEntity.class))).thenReturn(produtoEntitySalvo);

        Produto produtoCadastrado = produtoService.cadastrarProduto(produtoParaCadastrar);

        assertNotNull(produtoCadastrado);
        assertEquals("Produto Teste", produtoCadastrado.getNome());
        assertEquals("Smartphone", produtoCadastrado.getDescricao());
        assertEquals(1500.00, produtoCadastrado.getPreco());
        assertEquals(1, produtoCadastrado.getQtd());
        verify(produtoRepository).save(any(ProdutoEntity.class));

    }

    @Test
    void deveEncontrarProdutosPorIdComSucesso() {

        ProdutoEntity produtoEntity1 = new ProdutoEntity();
        produtoEntity1.setId(1L);
        produtoEntity1.setNome("Produto A");
        produtoEntity1.setDescricao("Produto A para teste");
        produtoEntity1.setPreco(100.0);
        produtoEntity1.setQtd(10);

        ProdutoEntity produtoEntity2 = new ProdutoEntity();
        produtoEntity2.setId(2L);
        produtoEntity2.setNome("Produto B");
        produtoEntity2.setDescricao("Produto B para teste");
        produtoEntity2.setPreco(200.0);
        produtoEntity2.setQtd(20);

        when(produtoRepository.findAll()).thenReturn(java.util.Arrays.asList(produtoEntity1, produtoEntity2));

        List<Produto> produtosEncontrados = produtoService.encontrarTodos();

        assertNotNull(produtosEncontrados);
        assertEquals(2, produtosEncontrados.size());
        assertEquals("Produto A", produtosEncontrados.get(0).getNome());
        assertEquals("Produto B", produtosEncontrados.get(1).getNome());
        verify(produtoRepository).findAll();

        }

    @Test
    void encontrarTodosOsProdutos() {

        ProdutoEntity produtoEntity1 = new ProdutoEntity();
        produtoEntity1.setId(1L);
        produtoEntity1.setNome("Produto A");
        produtoEntity1.setDescricao("Produto A para teste");
        produtoEntity1.setPreco(100.0);
        produtoEntity1.setQtd(10);

        ProdutoEntity produtoEntity2 = new ProdutoEntity();
        produtoEntity2.setId(2L);
        produtoEntity2.setNome("Produto B");
        produtoEntity2.setDescricao("Produto B para teste");
        produtoEntity2.setPreco(200.0);
        produtoEntity2.setQtd(20);

        when(produtoRepository.findAll()).thenReturn(java.util.Arrays.asList(produtoEntity1, produtoEntity2));

        List<Produto> produtosEncontrados = produtoService.encontrarTodos();

        assertNotNull(produtosEncontrados);
        assertEquals(2, produtosEncontrados.size());
        assertEquals("Produto A", produtosEncontrados.get(0).getNome());
        assertEquals("Produto B", produtosEncontrados.get(1).getNome());
        verify(produtoRepository).findAll();

        }

    

    }