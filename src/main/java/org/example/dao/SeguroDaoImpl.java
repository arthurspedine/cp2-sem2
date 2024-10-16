package org.example.dao;

import org.example.model.Seguro;
import org.example.model.TipoSeguro;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeguroDaoImpl implements SeguroDao {


    private final Connection connection;

    public SeguroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Seguro seguro) {
        String sql = "INSERT INTO T_SEG_SEGURO(valor, tipo) VALUES (?,?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"id"});
            pstmt.setDouble(1, seguro.getValor());
            pstmt.setString(2, seguro.getTipo().getDescricao());

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
    public List<Seguro> findAll() {
        List<Seguro> retorno = new ArrayList<>();
        String sql = "SELECT * FROM T_SEG_SEGURO";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Seguro seguro = new Seguro(
                        rs.getLong("id"),
                        rs.getDouble("valor"),
                        TipoSeguro.valueOf(rs.getString("tipo")
                        ));
                retorno.add(seguro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    @Override
    public void update(Seguro seguro) {
        String sql = "UPDATE T_SEG_SEGURO SET valor = ?, tipo = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, seguro.getId());
            pstmt.setDouble(2, seguro.getValor());
            pstmt.setString(3, seguro.getTipo().getDescricao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Seguro seguro) {
        String sql = "DELETE FROM T_SEG_SEGURO WHERE id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, seguro.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
