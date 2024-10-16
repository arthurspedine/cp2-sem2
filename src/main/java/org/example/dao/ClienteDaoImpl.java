package org.example.dao;

import org.example.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    private static ClienteDaoImpl clienteDaoImpl;
    private final Connection connection;

    public static synchronized ClienteDaoImpl getInstacia(Connection connection) {
        if (clienteDaoImpl == null) {
            clienteDaoImpl = new ClienteDaoImpl(connection);
        }
        return clienteDaoImpl;
    }

    private ClienteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Cliente cliente) {
        String sql = "INSERT INTO T_SEG_CLIENTE(nome, cpf, dt_nascimento, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"id"});
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getEndereco());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> retorno = new ArrayList<>();
        String sql = "SELECT * FROM T_SEG_CLIENTE";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
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
    public Cliente findById(Long id) {
        String sql = "SELECT * FROM T_SEG_CLIENTE WHERE id = ?";
        Cliente cliente = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("endereco")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE T_SEG_CLIENTE SET email = ?, endereco = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getEndereco());
            pstmt.setLong(3, cliente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM T_SEG_CLIENTE WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
