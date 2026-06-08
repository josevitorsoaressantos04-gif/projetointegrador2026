package sistema;

import sistema.DAO.*;
import sistema.model.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        DadosIniciaisDAO dadosIniciaisDAO = new DadosIniciaisDAO();
        dadosIniciaisDAO.inserirDadosIniciais();

        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        cliente.setCpfCnpj("00000000000");
        cliente.setTelefone("48999999999");
        cliente.setEmail("cliente@teste.com");

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrarCliente(cliente);

        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setDescricao("Produto criado para teste");
        produto.setValorCusto(new BigDecimal("10.00"));
        produto.setValorVenda(new BigDecimal("25.00"));
        produto.setEstoque(100);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);

        System.out.println("Dados de teste inseridos com sucesso.");
    }
}