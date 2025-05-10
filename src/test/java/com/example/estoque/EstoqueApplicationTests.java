package com.example.estoque;

import com.example.estoque.service.ProdutoService;
import com.example.estoque.service.ProdutoServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EstoqueApplicationTests {

	@Autowired
	private ProdutoService produtoService;

	@Test
	public void justRun() {
		Assertions.assertNotNull(produtoService);
	}

}
