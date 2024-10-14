package org.example.dao;

import org.example.model.Cliente;
import org.example.model.ClienteFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    private final Connection connection;

    public ClienteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO T_SEG_CLIENTE(nome, cpf, dt_nascimento, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getEndereco());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Cliente> findAll(ClienteFactory clienteFactory) {
        List<Cliente> retorno = new ArrayList<>();
        String sql = "SELECT * FROM T_SEG_CLIENTE";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = clienteFactory.createClienteComId(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("endereco")
                );

                retorno.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retorno;
    }

    @Override
    public Cliente findById(Long id, ClienteFactory clienteFactory) {
        return null;
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(Long id) {

    }
}
