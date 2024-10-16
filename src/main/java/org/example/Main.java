package org.example;

import org.example.config.DatabaseConfig;
import org.example.dao.ClienteDaoImpl;
import org.example.dao.ContratacaoDaoImpl;
import org.example.dao.SeguroDaoImpl;
import org.example.dao.SinistroDaoImpl;
import org.example.model.Cliente;
import org.example.model.Seguro;
import org.example.model.Sinistro;
import org.example.model.TipoSeguro;
import org.example.service.ContratacaoService;
import org.example.service.SinistroService;
import org.example.service.cliente.ClienteServiceFactory;
import org.example.service.cliente.IClienteService;
import org.example.service.seguro.ISeguroService;
import org.example.service.seguro.SeguroService;
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

        // CADASTRANDO UM CLIENTE NOVO
        Cliente clienteUm = new Cliente(null, "Arthur", "49076311897", LocalDate.parse("28/06/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "arthur@gmail.com", "Rua Teste 392");
        Long idCliente = clienteService.criarCliente(clienteUm);

        // CADASTRANDO UM SEGURO NOVO (SERA RELACIONADO AO CLIENTE)
        Seguro seguroMock = new Seguro(null, 1200.3, TipoSeguro.VIDA);
        Long idSeguro = seguroService.criarSeguro(seguroMock);

        // CADASTRANDO UMA CONTRATACAO QUE TERA O ID DO CLIENTE E ID DO SEGURO
        Long idContratacao = contratacaoService.criarContratacao(idCliente, idSeguro);

        // DESATIVANDO CONTRATACAO
        contratacaoService.desativarContratacao(idContratacao);

        try {
            contratacaoService.desativarContratacao(idContratacao);
        } catch (RuntimeException e) {
            // ERRO AO DESATIVAR UMA CONTRATAÇÃO INATIVA
            System.out.println(e.getMessage());
        }

        // CRIANDO NOVA CONTRATACAO COM NOVO SEGURO
        Long idSeguroDois = seguroService.criarSeguro(new Seguro(null, 1000.5, TipoSeguro.AUTOMOVEL));
        Long idContratacaoDois = contratacaoService.criarContratacao(idCliente, idSeguroDois);

        // CRIANDO UM SINISTRO
        Sinistro sinistro = new Sinistro(null, idContratacaoDois, "Eu bati meu carro", null, 820.5);
        Long id = sinistroService.criarSinistro(sinistro);
        System.out.println(sinistroService.buscarSinistro(id));




    }

}