package org.example;

import org.example.config.DatabaseConfig;
import org.example.dao.*;
import org.example.model.*;
import org.example.service.ContratacaoService;
import org.example.service.PagamentoService;
import org.example.service.SinistroService;
import org.example.service.cliente.ClienteServiceFactory;
import org.example.service.cliente.IClienteService;
import org.example.service.seguro.ISeguroService;
import org.example.service.seguro.SeguroServiceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public static final String USER = "rm554489";
    public static final String PASSWORD = "280606";

    public static void main(String[] args) throws SQLException {

        DatabaseConfig db = new DatabaseConfig(URL, USER, PASSWORD);
        Connection connection = db.getConnection();
        System.out.println("Conexão realizada com sucesso!");

        ClienteDaoImpl clienteDao = ClienteDaoImpl.getInstacia(connection);
        ClienteServiceFactory clienteServiceFactory = new ClienteServiceFactory();

        IClienteService clienteService = clienteServiceFactory.create(clienteDao);

        SeguroServiceFactory seguroServiceFactory = new SeguroServiceFactory();

        ISeguroService seguroService = seguroServiceFactory.create(new SeguroDaoImpl(connection));

        ContratacaoService contratacaoService = new ContratacaoService(new ContratacaoDaoImpl(connection));

        SinistroService sinistroService = new SinistroService(new SinistroDaoImpl(connection));

        PagamentoService pagamentoService = new PagamentoService(new PagamentoDaoImpl(connection));

        // CADASTRANDO UM CLIENTE NOVO
        Cliente clienteUm = new Cliente(null, "Arthur", "49076311897", LocalDate.parse("28/06/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "arthur@gmail.com", "Rua Teste 392");
        Long idCliente = clienteService.criarCliente(clienteUm);

        // CADASTRANDO UM SEGURO NOVO (SERA RELACIONADO AO CLIENTE)
        Seguro seguroMock = new Seguro(null, 1200.3, TipoSeguro.VIDA);
        Long idSeguro = seguroService.criarSeguro(seguroMock);

        // CADASTRANDO UMA CONTRATACAO QUE TERA O ID DO CLIENTE E ID DO SEGURO
        Long idContratacaoDesativada = contratacaoService.criarContratacao(idCliente, idSeguro);

        // DESATIVANDO CONTRATACAO
        contratacaoService.desativarContratacao(idContratacaoDesativada);

        try {
            contratacaoService.desativarContratacao(idContratacaoDesativada);
        } catch (RuntimeException e) {
            // ERRO AO DESATIVAR UMA CONTRATAÇÃO INATIVA
            System.out.println(e.getMessage());
        }

        // CRIANDO NOVA CONTRATACAO COM NOVO SEGURO
        Long idSeguroDois = seguroService.criarSeguro(new Seguro(null, 1000.5, TipoSeguro.AUTOMOVEL));
        Long idContratacaoDois = contratacaoService.criarContratacao(idCliente, idSeguroDois);

        // CRIANDO UM SINISTRO
        Sinistro sinistro = null;
        // REGRA -> CONTRATAÇÃO SEMPRE DEVE ESTAR ATIVA PARA FAZER UM SERVIÇO OU PAGAMENTO
        if (contratacaoService.findById(idContratacaoDois).isContratacaoAtiva()) {
            sinistro = new Sinistro(null, idContratacaoDois, "Eu bati meu carro", null, 820.5);
        }
        Long id = sinistroService.criarSinistro(sinistro);
        Sinistro sinistroBanco = sinistroService.buscarSinistro(id);
        System.out.println(sinistroBanco);

        try {
            // CODIGO FUNCIONA
            sinistroService.alterarStatus(sinistroBanco, StatusSinistro.FECHADO);
            System.out.println("Status do sinistro alterado com sucesso! Novo status: " + sinistroBanco.getStatus());
            // AGORA ATUALIZAR SENDO QUE O STATUS JA ESTA FECHADO ou RECUSADO
            sinistroService.alterarStatus(sinistroBanco, StatusSinistro.RECUSADO);
        } catch (RuntimeException e) {
            // ERRO AO ALTERAR STATUS DE UM SINISTRO
            System.out.println(e.getMessage());
        }

        // CRIANDO UM PAGAMENTO
        Pagamento pagamento = null;
        if (contratacaoService.findById(idContratacaoDois).isContratacaoAtiva()) {
            pagamento = new Pagamento(null, idContratacaoDois, 150.0, LocalDate.now());
        }
        Long idPagamentoNovo = pagamentoService.criarPagamento(pagamento);
        Pagamento pagamentoBanco = pagamentoService.buscarPagamento(idPagamentoNovo);
        System.out.println(pagamentoBanco);

        if (contratacaoService.findById(idContratacaoDesativada).isContratacaoAtiva()) {
            pagamento = new Pagamento(null, idContratacaoDesativada, 190.0, LocalDate.now());
        } else {
            System.out.println("contratacao desativada, nao pode ser criado um novo pagamento!");
        }

        connection.close();
    }

}